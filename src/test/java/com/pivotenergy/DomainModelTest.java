package com.pivotenergy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pivotenergy.domain.account.Role;
import com.pivotenergy.domain.account.User;
import com.pivotenergy.domain.opportunity.*;
import com.pivotenergy.domain.simulation.model.EnergyUseCalculation;
import com.pivotenergy.domain.simulation.model.MeasureSimulationResults;
import com.pivotenergy.domain.simulation.model.PackageSimulationResult;
import com.pivotenergy.domain.simulation.model.SimulationResults;
import com.pivotenergy.security.JWTAuthentication;
import com.pivotenergy.security.JWTPrincipal;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestConfiguration.class}, webEnvironment= SpringBootTest.WebEnvironment.NONE)
@TestPropertySource(locations="classpath:application.properties")
@Transactional
@Commit
@Rollback(false)
@Log4j
public class DomainModelTest {
    @Autowired
    PackageSimulationResultRepository packageSimulationResultRepository;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Test
    @Rollback(false)
    @Commit
    public void find_package_simulation_result_by_id() throws JsonProcessingException {
        User user = new User()
                .setFirstName("Test")
                .setLastName("User")
                .setId("@TEST_ACCOUNT")
                .setGroupId("@TEST_GROUP")
                .setEnabled(true)
                .setExpired(false)
                .setLocked(false)
                .setEmail("TEST_ACCOUNT@TEST_GROUP.COM")
                .setPassword("Password");
        user.getRoles().add(new Role().setRole(Role.Scope.ROLE_ADMIN, Role.Action.ADMIN, Role.Target.GLOBAL));
        JWTAuthentication jwtAuthentication = new JWTAuthentication(new JWTPrincipal(user), user.getPassword(), user.getRoles());
        SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);

        String id = "3bb21678-88ed-4e50-9ed5-0e300f5cbb22-PACKAGE_7D632C00";
        Measure measure = new Measure();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        log.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(measure));
        PackageSimulationResult result = packageSimulationResultRepository.findOne(id);

        Outcomes outcomes = toOpportunityOutcomes(result);
        /**
         *
         * @param baselineId the baseline used
         * @param scenarioId the scenario run
         * @param name the name
         * @param description the description
         * @param systemsRetrofitted the systems retrofitted
         * @param subSystemsRetrofitted the sub-systems retrofitted
         * @param buildingOutcome the whole building outcome accounting for interactive effects
         * @param measureOutcome the isolated retrofitted systems outcome ignoring interactive effects
         * @param baselineAnnualDisaggregation the baseline annual disaggregation
         * @param worstCaseOutcomeAnnualDisaggregation the worst case scenario annual disaggregation
         * @param mostLikelyOutcomeAnnualDisaggregation the most likely case scenario annual disaggregation
         * @param bestCaseOutcomeAnnualDisaggregation the best case scenario annual disaggregation
         * @param measures the list of measures applied
         * @param monthlyDisaggregation the monthly disaggregation
         */
        Opportunity opportunity = new Opportunity(
                result.getId(),
                result.getPackageId(),
                result.getPackageName(),
                result.getPackageDescription(),
                result.getSystems(),
                result.getComponents(),
                outcomes, // building
                outcomes, // measure
                toDisaggregation(result.getBaselineResults()), //baselineAnnualDisaggregation,
                toDisaggregation(result.getRetrofitLowerResults()), //worstCaseOutcomeAnnualDisaggregation,
                toDisaggregation(result.getRetrofitMeanResults()), //mostLikelyOutcomeAnnualDisaggregation,
                toDisaggregation(result.getRetrofitUpperResults()), //bestCaseOutcomeAnnualDisaggregation,
                null,
                null);

        Set<Measure> measures = result
                .getMeasureSimulationResults()
                .stream()
                .map(x -> toMeasure(x, opportunity))
                .collect(Collectors.toSet());

        opportunity
                .setMeasures(measures)
                .setMonthlyDisaggregation(toMonthlyOpportunityDisaggregationSet(result, opportunity));

        opportunityRepository.save(opportunity);
    }

    Outcomes toOpportunityOutcomes(PackageSimulationResult result) {
        Double grossCost = result.getInstallCost() + result.getProcurementCost();
        Double incentiveDirect = 0d;
        Double incentivePercent = 0d;
        Double netCost = grossCost - (incentiveDirect + (grossCost * incentivePercent));
        Double energyCostReduction = result.getRetrofitMeanResults().getAnnualCostReduction().getSummedTotal();
        Double energyConsumptionReduction = result.getIsolatedMeasureRiskMetrics().getMostLikelyEnergyReduction();
        Double peakConsumptionReduction = result.getRetrofitMeanResults().getAnnualConsumptionReduction().getPeakDemand();
        Double emissionsReduction = result.getRetrofitMeanResults().getAnnualEmissionsReduction().getSummedTotal();
        Integer paybackYears = (int) Math.min(100, netCost / energyCostReduction);
        Double electricPriceKwh = 0d;
        Double electricEmissionsPerKwh = 0d;
        Double discountRate = 0d;
        Double netPresentValue = 0d;
        Double internalRateOfReturn = 0d;
        Double costReductionRatio = 0d;
        Double returnOnInvestment = 0d;
        List<Double> presentValue = new ArrayList<>();
        List<Double> cumulativePresentValue = new ArrayList<>();
        List<Double> futureValue = new ArrayList<>();
        List<Double> cumulativeFutureValue = new ArrayList<>();

        PerformanceImpactType performanceImpactType = null;
        if(null != result.getPerformanceImpact()) {
            performanceImpactType = new PerformanceImpactType(
                    result.getPerformanceImpact().getName(),
                    result.getPerformanceImpact().getLowerScore(),
                    result.getPerformanceImpact().getUpperScore());
        }

        InfrastructureImpactType infrastructureImpactType = null;
        if(null != result.getInfrastructureImpact()) {
            infrastructureImpactType = new InfrastructureImpactType(
                    result.getInfrastructureImpact().getName(),
                    result.getInfrastructureImpact().getScore());
        }

        TenantImpactType tenantImpactType = null;
        if(null != result.getTenantImpact()) {
            tenantImpactType = new TenantImpactType(
                    result.getTenantImpact().getName(),
                    result.getTenantImpact().getScore());
        }

        HealthFactorType healthFactorType = new HealthFactorType();

        RiskMetrics riskMetrics = new RiskMetrics(
                result.getIsolatedMeasureRiskMetrics().getName(),
                result.getIsolatedMeasureRiskMetrics().getCdf(),
                result.getIsolatedMeasureRiskMetrics().getPdf(),
                result.getIsolatedMeasureRiskMetrics().getBins(),
                result.getIsolatedMeasureRiskMetrics().getStandardDeviation(),
                result.getIsolatedMeasureRiskMetrics().getUnderPerformanceRiskPercent(),
                result.getIsolatedMeasureRiskMetrics().getValueAtRisk(),
                result.getIsolatedMeasureRiskMetrics().getPerformanceAtRiskKwh(),
                result.getIsolatedMeasureRiskMetrics().getConfidenceInterval(),
                result.getIsolatedMeasureRiskMetrics().getExpectedEnergyReduction(),
                result.getIsolatedMeasureRiskMetrics().getExpectCostReduction(),
                result.getIsolatedMeasureRiskMetrics().getWorstCaseEnergyReduction(),
                result.getIsolatedMeasureRiskMetrics().getMostLikelyEnergyReduction(),
                result.getIsolatedMeasureRiskMetrics().getBestCaseEnergyReduction(),
                result.getIsolatedMeasureRiskMetrics().getRiskRating(),
                result.getIsolatedMeasureRiskMetrics().getModelCertainty());

        Financial financial = new Financial(discountRate, netPresentValue, internalRateOfReturn,
                costReductionRatio, returnOnInvestment, result.getEffectiveLifeYears(), paybackYears,
                emissionsReduction, energyCostReduction, result.getAnnualMaintenanceCost(),
                presentValue, cumulativePresentValue, futureValue, cumulativeFutureValue);

        return new Outcomes(grossCost, incentiveDirect, incentivePercent, netCost, energyCostReduction,
                energyConsumptionReduction, peakConsumptionReduction, emissionsReduction, paybackYears,
                electricPriceKwh, electricEmissionsPerKwh, performanceImpactType, infrastructureImpactType,
                tenantImpactType, healthFactorType, riskMetrics, financial);
    }

    Outcomes toMeasureOutcomes(MeasureSimulationResults result) {
        Double grossCost = result.getInstallCost() + result.getProcurementCost();
        Double incentiveDirect = 0d;
        Double incentivePercent = 0d;
        Double netCost = grossCost - (incentiveDirect + (grossCost * incentivePercent));
        Double energyCostReduction = result.getRetrofitMeanResults().getAnnualCostReduction().getSummedTotal();
        Double energyConsumptionReduction = result.getIsolatedMeasureRiskMetrics().getMostLikelyEnergyReduction();
        Double peakConsumptionReduction = result.getRetrofitMeanResults().getAnnualConsumptionReduction().getPeakDemand();
        Double emissionsReduction = result.getRetrofitMeanResults().getAnnualEmissionsReduction().getSummedTotal();
        Integer paybackYears = (int) Math.min(100, netCost / energyCostReduction);
        Double electricPriceKwh = 0d;
        Double electricEmissionsPerKwh = 0d;
        Double discountRate = 0d;
        Double netPresentValue = 0d;
        Double internalRateOfReturn = 0d;
        Double costReductionRatio = 0d;
        Double returnOnInvestment = 0d;
        List<Double> presentValue = new ArrayList<>();
        List<Double> cumulativePresentValue = new ArrayList<>();
        List<Double> futureValue = new ArrayList<>();
        List<Double> cumulativeFutureValue = new ArrayList<>();

        PerformanceImpactType performanceImpactType = null;
        if(null != result.getPerformanceImpact()) {
            performanceImpactType = new PerformanceImpactType(
                    result.getPerformanceImpact().getName(),
                    result.getPerformanceImpact().getLowerScore(),
                    result.getPerformanceImpact().getUpperScore());
        }

        InfrastructureImpactType infrastructureImpactType = null;
        if(null != result.getInfrastructureImpact()) {
            infrastructureImpactType = new InfrastructureImpactType(
                    result.getInfrastructureImpact().getName(),
                    result.getInfrastructureImpact().getScore());
        }

        TenantImpactType tenantImpactType = null;
        if(null != result.getTenantImpact()) {
            tenantImpactType = new TenantImpactType(
                    result.getTenantImpact().getName(),
                    result.getTenantImpact().getScore());
        }

        HealthFactorType healthFactorType = new HealthFactorType();

        RiskMetrics riskMetrics = new RiskMetrics(
                result.getIsolatedMeasureRiskMetrics().getName(),
                result.getIsolatedMeasureRiskMetrics().getCdf(),
                result.getIsolatedMeasureRiskMetrics().getPdf(),
                result.getIsolatedMeasureRiskMetrics().getBins(),
                result.getIsolatedMeasureRiskMetrics().getStandardDeviation(),
                result.getIsolatedMeasureRiskMetrics().getUnderPerformanceRiskPercent(),
                result.getIsolatedMeasureRiskMetrics().getValueAtRisk(),
                result.getIsolatedMeasureRiskMetrics().getPerformanceAtRiskKwh(),
                result.getIsolatedMeasureRiskMetrics().getConfidenceInterval(),
                result.getIsolatedMeasureRiskMetrics().getExpectedEnergyReduction(),
                result.getIsolatedMeasureRiskMetrics().getExpectCostReduction(),
                result.getIsolatedMeasureRiskMetrics().getWorstCaseEnergyReduction(),
                result.getIsolatedMeasureRiskMetrics().getMostLikelyEnergyReduction(),
                result.getIsolatedMeasureRiskMetrics().getBestCaseEnergyReduction(),
                result.getIsolatedMeasureRiskMetrics().getRiskRating(),
                result.getIsolatedMeasureRiskMetrics().getModelCertainty());

        Financial financial = new Financial(discountRate, netPresentValue, internalRateOfReturn,
                costReductionRatio, returnOnInvestment, result.getEffectiveLife(), paybackYears,
                emissionsReduction, energyCostReduction, result.getAnnualMaintenanceCost(),
                presentValue, cumulativePresentValue, futureValue, cumulativeFutureValue);

        return new Outcomes(grossCost, incentiveDirect, incentivePercent, netCost, energyCostReduction,
                energyConsumptionReduction, peakConsumptionReduction, emissionsReduction, paybackYears,
                electricPriceKwh, electricEmissionsPerKwh, performanceImpactType, infrastructureImpactType,
                tenantImpactType, healthFactorType, riskMetrics, financial);
    }

    Disaggregation toDisaggregation(SimulationResults result) {
        SummaryAnnual cost = toSummaryAnnual(result.getAnnualCost());
        SummaryAnnual consumption = toSummaryAnnual(result.getAnnualConsumption());
        SummaryAnnual emissions = toSummaryAnnual(result.getAnnualEmissions());

        return new Disaggregation(cost, consumption, emissions);
    }

    Set<MonthlyOpportunityDisaggregation> toMonthlyOpportunityDisaggregationSet(PackageSimulationResult result,
                                                                                Opportunity opportunity) {
        Set<MonthlyOpportunityDisaggregation> set = new HashSet<>();
        for(int i = 0; i < 12; i++ ) {
            Integer month = 1+i;
            Disaggregation baseline = new Disaggregation(
                    toSummaryAnnual(result.getBaselineResults().getMonthlyCost().get(i)),
                    toSummaryAnnual(result.getBaselineResults().getMonthlyConsumption().get(i)),
                    toSummaryAnnual(result.getBaselineResults().getMonthlyEmissions().get(i)));

            Disaggregation worstCase = new Disaggregation(
                    toSummaryAnnual(result.getRetrofitLowerResults().getMonthlyCost().get(i)),
                    toSummaryAnnual(result.getRetrofitLowerResults().getMonthlyConsumption().get(i)),
                    toSummaryAnnual(result.getRetrofitLowerResults().getMonthlyEmissions().get(i)));

            Disaggregation mostLikely = new Disaggregation(
                    toSummaryAnnual(result.getRetrofitMeanResults().getMonthlyCost().get(i)),
                    toSummaryAnnual(result.getRetrofitMeanResults().getMonthlyConsumption().get(i)),
                    toSummaryAnnual(result.getRetrofitMeanResults().getMonthlyEmissions().get(i)));

            Disaggregation bestCase = new Disaggregation(
                    toSummaryAnnual(result.getRetrofitUpperResults().getMonthlyCost().get(i)),
                    toSummaryAnnual(result.getRetrofitUpperResults().getMonthlyConsumption().get(i)),
                    toSummaryAnnual(result.getRetrofitUpperResults().getMonthlyEmissions().get(i)));
            /*
             *
             * Integer month,
             * Disaggregation baselineAnnualDisaggregation,
             * Disaggregation worstCaseOutcomeAnnualDisaggregation,
             * Disaggregation mostLikelyOutcomeAnnualDisaggregation,
             * Disaggregation bestCaseOutcomeAnnualDisaggregation,
             * Measure measure
             */
            set.add(new MonthlyOpportunityDisaggregation(month, baseline, worstCase, mostLikely, bestCase, opportunity));
        }

        return set;
    }

    Set<MonthlyMeasureDisaggregation> toMonthlyMeasureDisaggregationSet(MeasureSimulationResults result,
                                                                        Measure measure) {
        Set<MonthlyMeasureDisaggregation> set = new HashSet<>();
        for(int i = 0; i < 12; i++ ) {
            Integer month = 1+i;
            Disaggregation baseline = new Disaggregation(
                    toSummaryAnnual(result.getBaselineResults().getMonthlyCost().get(i)),
                    toSummaryAnnual(result.getBaselineResults().getMonthlyConsumption().get(i)),
                    toSummaryAnnual(result.getBaselineResults().getMonthlyEmissions().get(i)));

            Disaggregation worstCase = new Disaggregation(
                    toSummaryAnnual(result.getRetrofitLowerResults().getMonthlyCost().get(i)),
                    toSummaryAnnual(result.getRetrofitLowerResults().getMonthlyConsumption().get(i)),
                    toSummaryAnnual(result.getRetrofitLowerResults().getMonthlyEmissions().get(i)));

            Disaggregation mostLikely = new Disaggregation(
                    toSummaryAnnual(result.getRetrofitMeanResults().getMonthlyCost().get(i)),
                    toSummaryAnnual(result.getRetrofitMeanResults().getMonthlyConsumption().get(i)),
                    toSummaryAnnual(result.getRetrofitMeanResults().getMonthlyEmissions().get(i)));

            Disaggregation bestCase = new Disaggregation(
                    toSummaryAnnual(result.getRetrofitUpperResults().getMonthlyCost().get(i)),
                    toSummaryAnnual(result.getRetrofitUpperResults().getMonthlyConsumption().get(i)),
                    toSummaryAnnual(result.getRetrofitUpperResults().getMonthlyEmissions().get(i)));
            /*
             *
             * Integer month,
             * Disaggregation baselineAnnualDisaggregation,
             * Disaggregation worstCaseOutcomeAnnualDisaggregation,
             * Disaggregation mostLikelyOutcomeAnnualDisaggregation,
             * Disaggregation bestCaseOutcomeAnnualDisaggregation,
             * Measure measure
             */
            set.add(new MonthlyMeasureDisaggregation(month, baseline, worstCase, mostLikely, bestCase, measure));
        }

        return set;
    }

    SummaryAnnual toSummaryAnnual(EnergyUseCalculation use) {
        HVAC hvac = new HVAC(use.heating, use.cooling, use.fans, use.pumps, use.domesticHotWater);
        Lighting lighting = new Lighting(use.internalLighting, use.externalLighting);
        PlugLoad plugLoad = new PlugLoad(use.electricPointLoads, use.fossilFuelPointLoads);
        Renewable renewable = new Renewable(use.solarHotWater, use.photovoltaic, use.windTurbine);
        return new SummaryAnnual(hvac, lighting, plugLoad, renewable);
    }

    Measure toMeasure(MeasureSimulationResults result, Opportunity opportunity) {
        Outcomes outcomes = toMeasureOutcomes(result);

        Measure measure = new Measure(
                result.getMeasureName(),
                result.getMeasureDescription(),
                result.getSystems(),
                result.getComponents(),
                outcomes,
                outcomes,
                toDisaggregation(result.getBaselineResults()), //baselineAnnualDisaggregation,
                toDisaggregation(result.getRetrofitLowerResults()), //worstCaseOutcomeAnnualDisaggregation,
                toDisaggregation(result.getRetrofitMeanResults()), //mostLikelyOutcomeAnnualDisaggregation,
                toDisaggregation(result.getRetrofitUpperResults()), //bestCaseOutcomeAnnualDisaggregation,
                null,
                null,
                opportunity);

        return measure.setMonthlyDisaggregation(toMonthlyMeasureDisaggregationSet(result, measure));
    }
}
