package com.pivotenergy.domain.simulation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pivotenergy.domain.opportunity.InfrastructureImpactType;
import com.pivotenergy.domain.opportunity.PerformanceImpactType;
import com.pivotenergy.domain.opportunity.RiskMetrics;
import com.pivotenergy.domain.opportunity.TenantImpactType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="PackageSimulationResult")
public class PackageSimulationResult {
    @Id
    protected String id;
    @Indexed
    protected String groupId;
    @Indexed
    protected String buildingId;
    @Indexed
    protected String packageId;
    protected String packageName;
    protected String packageDescription;
    @Indexed
    protected Set<String> systems;
    @Indexed
    protected Set<String> components;
    protected PerformanceImpactType performanceImpact;
    protected Double performanceImpactScore;

    protected PerformanceImpactType isolatedPerformanceImpact;
    protected Double isolatedPerformanceImpactScore;
    protected InfrastructureImpactType infrastructureImpact;
    protected Double infrastructureImpactScore;
    protected TenantImpactType tenantImpact;
    protected Double tenantImpactScore;
    protected Double totalInitialInvestment;
    protected Double procurementCost;
    protected Double installCost;
    protected Double installTime;
    protected Double annualMaintenanceCost;
    protected Integer effectiveLifeYears;
    protected Double totalLifeTimeCost;
    protected Double electricPricePerkWh;
    protected Double fossilFuelPricePerkWh;
    protected Double districtHeatingPricePerkWh;
    protected Double districtCoolingPricePerkWh ;
    protected Double electricKgCO2PerkWh;
    protected Double fossilFuelKgCO2PerkWh;
    protected Double districtHeatingKgCO2PerkWh;
    protected Double districtCoolingKgCO2PerkWh;
    protected String healthFactors;
    protected String inclusionCondition;
    protected boolean included;
    protected List<MeasureSimulationResults> measureSimulationResults;
    protected SimulationResults baselineResults;
    protected SimulationResults retrofitLowerResults;
    protected SimulationResults retrofitMeanResults;
    protected SimulationResults retrofitUpperResults;
    protected RiskMetrics riskMetrics;
    protected RiskMetrics isolatedMeasureRiskMetrics;
    protected Double grossFloorArea;
    protected Double expectedCostReduction;
    protected Double expectedEnergyReduction;
    protected Double expectedEmissionsReduction;
}
