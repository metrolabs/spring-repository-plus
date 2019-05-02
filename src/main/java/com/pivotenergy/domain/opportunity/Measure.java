/*
 * ________________________________________________________________________
 * METRO.IO CONFIDENTIAL
 * ________________________________________________________________________
 *
 * Copyright (c) 2017.
 * Metro Labs Incorporated
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains
 * the property of Metro Labs Incorporated and its suppliers,
 * if any. The intellectual and technical concepts contained
 * herein are proprietary to Metro Labs Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Metro Labs Incorporated.
 */

package com.pivotenergy.domain.opportunity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pivotenergy.domain.MultiTenantBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("unused")
@Entity
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Measure extends MultiTenantBaseEntity<Measure> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Convert(converter = StringSetConverter.class)
    @Column(name = "systems", columnDefinition="TEXT")
    private Set<String> systemsRetrofitted;

    @Convert(converter = StringSetConverter.class)
    @Column(name = "components", columnDefinition="TEXT")
    private Set<String> subSystemsRetrofitted;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="grossCost", column = @Column(name="building_gross_cost")),
            @AttributeOverride(name="incentiveDirect", column = @Column(name="building_incentive_direct")),
            @AttributeOverride(name="incentivePercent", column = @Column(name="building_incentive_percent")),
            @AttributeOverride(name="netCost", column = @Column(name="building_net_cost")),
            @AttributeOverride(name="energyCostReduction", column = @Column(name="building_energy_cost_reduction")),
            @AttributeOverride(name="energyConsumptionReduction", column = @Column(name="building_energy_consumption_reduction")),
            @AttributeOverride(name="peakConsumptionReduction", column = @Column(name="building_peak_energy_consumption_reduction")),
            @AttributeOverride(name="emissionsReduction", column = @Column(name="building_emissions_reduction")),
            @AttributeOverride(name="paybackYears", column = @Column(name="building_payback_years")),
            @AttributeOverride(name="electricPriceKwh", column = @Column(name="building_electric_price_kwh")),
            @AttributeOverride(name="electricEmissionsPerKwh", column = @Column(name="building_electric_co2_kwh")),
            @AttributeOverride(name="performanceImpact.name", column = @Column(name="building_performance_impact_name")),
            @AttributeOverride(name="performanceImpact.lowerScore", column = @Column(name="building_performance_impact_name_lower_score")),
            @AttributeOverride(name="performanceImpact.upperScore", column = @Column(name="building_performance_impact_name_upper_score")),
            @AttributeOverride(name="infrastructureImpact.name", column = @Column(name="building_infrastructure_impact_name")),
            @AttributeOverride(name="infrastructureImpact.score", column = @Column(name="building_infrastructure_impact_score")),
            @AttributeOverride(name="tenantImpact.name", column = @Column(name="building_tenant_impact_name")),
            @AttributeOverride(name="tenantImpact.score", column = @Column(name="building_tenant_impact_score")),
            @AttributeOverride(name="healthFactor.name", column = @Column(name="building_health_factor_name")),
            @AttributeOverride(name="healthFactor.score", column = @Column(name="building_health_factor_score")),
            @AttributeOverride(name="riskMetrics.name", column = @Column(name="building_risk_name")),
            @AttributeOverride(name="riskMetrics.cdf", column = @Column(name="building_risk_cdf", columnDefinition="TEXT")),
            @AttributeOverride(name="riskMetrics.pdf", column = @Column(name="building_risk_pdf", columnDefinition="TEXT")),
            @AttributeOverride(name="riskMetrics.bins", column = @Column(name="building_risk_bins", columnDefinition="TEXT")),
            @AttributeOverride(name="riskMetrics.standardDeviation", column = @Column(name="building_risk_stdev")),
            @AttributeOverride(name="riskMetrics.underPerformanceRiskPercent", column = @Column(name="building_risk_under_performance")),
            @AttributeOverride(name="riskMetrics.valueAtRisk", column = @Column(name="building_risk_var")),
            @AttributeOverride(name="riskMetrics.performanceAtRiskKwh", column = @Column(name="building_risk_pvar_kwh")),
            @AttributeOverride(name="riskMetrics.confidenceInterval", column = @Column(name="building_risk_confidence_interval")),
            @AttributeOverride(name="riskMetrics.expectedEnergyReduction", column = @Column(name="building_risk_expected_energy_reduction")),
            @AttributeOverride(name="riskMetrics.expectCostReduction", column = @Column(name="building_risk_expect_cost_reduction")),
            @AttributeOverride(name="riskMetrics.worstCaseEnergyReduction", column = @Column(name="building_risk_worst_case_energy_reduction")),
            @AttributeOverride(name="riskMetrics.mostLikelyEnergyReduction", column = @Column(name="building_risk_most_likely_energy_reduction")),
            @AttributeOverride(name="riskMetrics.bestCaseEnergyReduction", column = @Column(name="building_risk_best_case_energy_reduction")),
            @AttributeOverride(name="riskMetrics.riskRating", column = @Column(name="building_risk_rating")),
            @AttributeOverride(name="riskMetrics.modelCertainty", column = @Column(name="building_risk_certainty")),
            @AttributeOverride(name="financial.discountRate", column = @Column(name="building_financial_dr")),
            @AttributeOverride(name="financial.netPresentValue", column = @Column(name="building_financial_npv")),
            @AttributeOverride(name="financial.internalRateOfReturn", column = @Column(name="building_financial_irr")),
            @AttributeOverride(name="financial.costReductionRatio", column = @Column(name="building_financial_crr")),
            @AttributeOverride(name="financial.returnOnInvestment", column = @Column(name="building_financial_roi")),
            @AttributeOverride(name="financial.usefulLifeYears", column = @Column(name="building_financial_uly")),
            @AttributeOverride(name="financial.paybackYears", column = @Column(name="building_financial_payback_years")),
            @AttributeOverride(name="financial.totalEmissionsReduction", column = @Column(name="building_financial_total_emission_reduction_kg")),
            @AttributeOverride(name="financial.costReduction", column = @Column(name="building_financial_cost_reduction")),
            @AttributeOverride(name="financial.reoccurringCost", column = @Column(name="building_financial_reoccurring_cost")),
            @AttributeOverride(name="financial.presentValue", column = @Column(name="building_financial_npv_array")),
            @AttributeOverride(name="financial.cumulativePresentValue", column = @Column(name="building_financial_cumulative_npv_array")),
            @AttributeOverride(name="financial.futureValue", column = @Column(name="building_financial_fv_array")),
            @AttributeOverride(name="financial.cumulativeFutureValue", column = @Column(name="building_financial_cumulative_fv_array"))
    })
    private Outcomes buildingOutcome;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="grossCost", column = @Column(name="measure_gross_cost")),
            @AttributeOverride(name="incentiveDirect", column = @Column(name="measure_incentive_direct")),
            @AttributeOverride(name="incentivePercent", column = @Column(name="measure_incentive_percent")),
            @AttributeOverride(name="netCost", column = @Column(name="measure_net_cost")),
            @AttributeOverride(name="energyCostReduction", column = @Column(name="measure_energy_cost_reduction")),
            @AttributeOverride(name="energyConsumptionReduction", column = @Column(name="measure_energy_consumption_reduction")),
            @AttributeOverride(name="peakConsumptionReduction", column = @Column(name="measure_peak_energy_consumption_reduction")),
            @AttributeOverride(name="emissionsReduction", column = @Column(name="measure_emissions_reduction")),
            @AttributeOverride(name="paybackYears", column = @Column(name="measure_payback_years")),
            @AttributeOverride(name="electricPriceKwh", column = @Column(name="measure_electric_price_kwh")),
            @AttributeOverride(name="electricEmissionsPerKwh", column = @Column(name="measure_electric_co2_kwh")),
            @AttributeOverride(name="performanceImpact.name", column = @Column(name="measure_performance_impact_name")),
            @AttributeOverride(name="performanceImpact.lowerScore", column = @Column(name="measure_performance_impact_name_lower_score")),
            @AttributeOverride(name="performanceImpact.upperScore", column = @Column(name="measure_performance_impact_name_upper_score")),
            @AttributeOverride(name="infrastructureImpact.name", column = @Column(name="measure_infrastructure_impact_name")),
            @AttributeOverride(name="infrastructureImpact.score", column = @Column(name="measure_infrastructure_impact_score")),
            @AttributeOverride(name="tenantImpact.name", column = @Column(name="measure_tenant_impact_name")),
            @AttributeOverride(name="tenantImpact.score", column = @Column(name="measure_tenant_impact_score")),
            @AttributeOverride(name="healthFactor.name", column = @Column(name="measure_health_factor_name")),
            @AttributeOverride(name="healthFactor.score", column = @Column(name="measure_health_factor_score")),
            @AttributeOverride(name="riskMetrics.name", column = @Column(name="measure_risk_name")),
            @AttributeOverride(name="riskMetrics.cdf", column = @Column(name="measure_risk_cdf", columnDefinition="TEXT")),
            @AttributeOverride(name="riskMetrics.pdf", column = @Column(name="measure_risk_pdf", columnDefinition="TEXT")),
            @AttributeOverride(name="riskMetrics.bins", column = @Column(name="measure_risk_bins", columnDefinition="TEXT")),
            @AttributeOverride(name="riskMetrics.standardDeviation", column = @Column(name="measure_risk_stdev")),
            @AttributeOverride(name="riskMetrics.underPerformanceRiskPercent", column = @Column(name="measure_risk_under_performance")),
            @AttributeOverride(name="riskMetrics.valueAtRisk", column = @Column(name="measure_risk_var")),
            @AttributeOverride(name="riskMetrics.performanceAtRiskKwh", column = @Column(name="measure_risk_pvar_kwh")),
            @AttributeOverride(name="riskMetrics.confidenceInterval", column = @Column(name="measure_risk_confidence_interval")),
            @AttributeOverride(name="riskMetrics.expectedEnergyReduction", column = @Column(name="measure_risk_expected_energy_reduction")),
            @AttributeOverride(name="riskMetrics.expectCostReduction", column = @Column(name="measure_risk_expect_cost_reduction")),
            @AttributeOverride(name="riskMetrics.worstCaseEnergyReduction", column = @Column(name="measure_risk_worst_case_energy_reduction")),
            @AttributeOverride(name="riskMetrics.mostLikelyEnergyReduction", column = @Column(name="measure_risk_most_likely_energy_reduction")),
            @AttributeOverride(name="riskMetrics.bestCaseEnergyReduction", column = @Column(name="measure_risk_best_case_energy_reduction")),
            @AttributeOverride(name="riskMetrics.riskRating", column = @Column(name="measure_risk_rating")),
            @AttributeOverride(name="riskMetrics.modelCertainty", column = @Column(name="measure_risk_certainty")),
            @AttributeOverride(name="financial.discountRate", column = @Column(name="measure_financial_dr")),
            @AttributeOverride(name="financial.netPresentValue", column = @Column(name="measure_financial_npv")),
            @AttributeOverride(name="financial.internalRateOfReturn", column = @Column(name="measure_financial_irr")),
            @AttributeOverride(name="financial.costReductionRatio", column = @Column(name="measure_financial_crr")),
            @AttributeOverride(name="financial.returnOnInvestment", column = @Column(name="measure_financial_roi")),
            @AttributeOverride(name="financial.usefulLifeYears", column = @Column(name="measure_financial_uly")),
            @AttributeOverride(name="financial.paybackYears", column = @Column(name="measure_financial_payback_years")),
            @AttributeOverride(name="financial.totalEmissionsReduction", column = @Column(name="measure_financial_total_emission_reduction_kg")),
            @AttributeOverride(name="financial.costReduction", column = @Column(name="measure_financial_cost_reduction")),
            @AttributeOverride(name="financial.reoccurringCost", column = @Column(name="measure_financial_reoccurring_cost")),
            @AttributeOverride(name="financial.presentValue", column = @Column(name="measure_financial_npv_array")),
            @AttributeOverride(name="financial.cumulativePresentValue", column = @Column(name="measure_financial_cumulative_npv_array")),
            @AttributeOverride(name="financial.futureValue", column = @Column(name="measure_financial_fv_array")),
            @AttributeOverride(name="financial.cumulativeFutureValue", column = @Column(name="measure_financial_cumulative_fv_array"))
    })
    private Outcomes measureOutcome;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="cost.hvac.heating", column = @Column(name="baseline_cost_heat")),
            @AttributeOverride(name="cost.hvac.cooling", column = @Column(name="baseline_cost_cool")),
            @AttributeOverride(name="cost.hvac.ventilation", column = @Column(name="baseline_cost_vent")),
            @AttributeOverride(name="cost.hvac.pumps", column = @Column(name="baseline_cost_pumps")),
            @AttributeOverride(name="cost.hvac.domesticHotWater", column = @Column(name="baseline_cost_dhw")),
            @AttributeOverride(name="cost.lighting.internalLighting", column = @Column(name="baseline_cost_int_light")),
            @AttributeOverride(name="cost.lighting.externalLighting", column = @Column(name="baseline_cost_ext_light")),
            @AttributeOverride(name="cost.plugLoad.electricPlugLoads", column = @Column(name="baseline_cost_elec_pload")),
            @AttributeOverride(name="cost.plugLoad.fossilFuelPlugLoads", column = @Column(name="baseline_cost_ff_pload")),
            @AttributeOverride(name="cost.renewable.solarHotWaterGeneration", column = @Column(name="baseline_cost_shw_gen")),
            @AttributeOverride(name="cost.renewable.photovoltaicGeneration", column = @Column(name="baseline_cost_photo_gen")),
            @AttributeOverride(name="cost.renewable.windTurbineGeneration", column = @Column(name="baseline_cost_wind_gen")),
            @AttributeOverride(name="cost.total", column = @Column(name="baseline_cost_total")),

            @AttributeOverride(name="consumption.hvac.heating", column = @Column(name="baseline_consumption_heat")),
            @AttributeOverride(name="consumption.hvac.cooling", column = @Column(name="baseline_consumption_cool")),
            @AttributeOverride(name="consumption.hvac.ventilation", column = @Column(name="baseline_consumption_vent")),
            @AttributeOverride(name="consumption.hvac.pumps", column = @Column(name="baseline_consumption_pumps")),
            @AttributeOverride(name="consumption.hvac.domesticHotWater", column = @Column(name="baseline_consumption_dhw")),
            @AttributeOverride(name="consumption.lighting.internalLighting", column = @Column(name="baseline_consumption_int_light")),
            @AttributeOverride(name="consumption.lighting.externalLighting", column = @Column(name="baseline_consumption_ext_light")),
            @AttributeOverride(name="consumption.plugLoad.electricPlugLoads", column = @Column(name="baseline_consumption_elec_pload")),
            @AttributeOverride(name="consumption.plugLoad.fossilFuelPlugLoads", column = @Column(name="baseline_consumption_ff_pload")),
            @AttributeOverride(name="consumption.renewable.solarHotWaterGeneration", column = @Column(name="baseline_consumption_shw_gen")),
            @AttributeOverride(name="consumption.renewable.photovoltaicGeneration", column = @Column(name="baseline_consumption_photo_gen")),
            @AttributeOverride(name="consumption.renewable.windTurbineGeneration", column = @Column(name="baseline_consumption_wind_gen")),
            @AttributeOverride(name="consumption.total", column = @Column(name="baseline_consumption_total")),

            @AttributeOverride(name="emissions.hvac.heating", column = @Column(name="baseline_emissions_heat")),
            @AttributeOverride(name="emissions.hvac.cooling", column = @Column(name="baseline_emissions_cool")),
            @AttributeOverride(name="emissions.hvac.ventilation", column = @Column(name="baseline_emissions_vent")),
            @AttributeOverride(name="emissions.hvac.pumps", column = @Column(name="baseline_emissions_pumps")),
            @AttributeOverride(name="emissions.hvac.domesticHotWater", column = @Column(name="baseline_emissions_dhw")),
            @AttributeOverride(name="emissions.lighting.internalLighting", column = @Column(name="baseline_emissions_int_light")),
            @AttributeOverride(name="emissions.lighting.externalLighting", column = @Column(name="baseline_emissions_ext_light")),
            @AttributeOverride(name="emissions.plugLoad.electricPlugLoads", column = @Column(name="baseline_emissions_elec_pload")),
            @AttributeOverride(name="emissions.plugLoad.fossilFuelPlugLoads", column = @Column(name="baseline_emissions_ff_pload")),
            @AttributeOverride(name="emissions.renewable.solarHotWaterGeneration", column = @Column(name="baseline_emissions_shw_gen")),
            @AttributeOverride(name="emissions.renewable.photovoltaicGeneration", column = @Column(name="baseline_emissions_photo_gen")),
            @AttributeOverride(name="emissions.renewable.windTurbineGeneration", column = @Column(name="baseline_emissions_wind_gen")),
            @AttributeOverride(name="emissions.total", column = @Column(name="baseline_emissions_total"))
    })
    private Disaggregation baselineAnnualDisaggregation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="cost.hvac.heating", column = @Column(name="worst_case_cost_heat")),
            @AttributeOverride(name="cost.hvac.cooling", column = @Column(name="worst_case_cost_cool")),
            @AttributeOverride(name="cost.hvac.ventilation", column = @Column(name="worst_case_cost_vent")),
            @AttributeOverride(name="cost.hvac.pumps", column = @Column(name="worst_case_cost_pumps")),
            @AttributeOverride(name="cost.hvac.domesticHotWater", column = @Column(name="worst_case_cost_dhw")),
            @AttributeOverride(name="cost.lighting.internalLighting", column = @Column(name="worst_case_cost_int_light")),
            @AttributeOverride(name="cost.lighting.externalLighting", column = @Column(name="worst_case_cost_ext_light")),
            @AttributeOverride(name="cost.plugLoad.electricPlugLoads", column = @Column(name="worst_case_cost_elec_pload")),
            @AttributeOverride(name="cost.plugLoad.fossilFuelPlugLoads", column = @Column(name="worst_case_cost_ff_pload")),
            @AttributeOverride(name="cost.renewable.solarHotWaterGeneration", column = @Column(name="worst_case_cost_shw_gen")),
            @AttributeOverride(name="cost.renewable.photovoltaicGeneration", column = @Column(name="worst_case_cost_photo_gen")),
            @AttributeOverride(name="cost.renewable.windTurbineGeneration", column = @Column(name="worst_case_cost_wind_gen")),
            @AttributeOverride(name="cost.total", column = @Column(name="worst_case_cost_total")),

            @AttributeOverride(name="consumption.hvac.heating", column = @Column(name="worst_case_consumption_heat")),
            @AttributeOverride(name="consumption.hvac.cooling", column = @Column(name="worst_case_consumption_cool")),
            @AttributeOverride(name="consumption.hvac.ventilation", column = @Column(name="worst_case_consumption_vent")),
            @AttributeOverride(name="consumption.hvac.pumps", column = @Column(name="worst_case_consumption_pumps")),
            @AttributeOverride(name="consumption.hvac.domesticHotWater", column = @Column(name="worst_case_consumption_dhw")),
            @AttributeOverride(name="consumption.lighting.internalLighting", column = @Column(name="worst_case_consumption_int_light")),
            @AttributeOverride(name="consumption.lighting.externalLighting", column = @Column(name="worst_case_consumption_ext_light")),
            @AttributeOverride(name="consumption.plugLoad.electricPlugLoads", column = @Column(name="worst_case_consumption_elec_pload")),
            @AttributeOverride(name="consumption.plugLoad.fossilFuelPlugLoads", column = @Column(name="worst_case_consumption_ff_pload")),
            @AttributeOverride(name="consumption.renewable.solarHotWaterGeneration", column = @Column(name="worst_case_consumption_shw_gen")),
            @AttributeOverride(name="consumption.renewable.photovoltaicGeneration", column = @Column(name="worst_case_consumption_photo_gen")),
            @AttributeOverride(name="consumption.renewable.windTurbineGeneration", column = @Column(name="worst_case_consumption_wind_gen")),
            @AttributeOverride(name="consumption.total", column = @Column(name="worst_case_consumption_total")),

            @AttributeOverride(name="emissions.hvac.heating", column = @Column(name="worst_case_emissions_heat")),
            @AttributeOverride(name="emissions.hvac.cooling", column = @Column(name="worst_case_emissions_cool")),
            @AttributeOverride(name="emissions.hvac.ventilation", column = @Column(name="worst_case_emissions_vent")),
            @AttributeOverride(name="emissions.hvac.pumps", column = @Column(name="worst_case_emissions_pumps")),
            @AttributeOverride(name="emissions.hvac.domesticHotWater", column = @Column(name="worst_case_emissions_dhw")),
            @AttributeOverride(name="emissions.lighting.internalLighting", column = @Column(name="worst_case_emissions_int_light")),
            @AttributeOverride(name="emissions.lighting.externalLighting", column = @Column(name="worst_case_emissions_ext_light")),
            @AttributeOverride(name="emissions.plugLoad.electricPlugLoads", column = @Column(name="worst_case_emissions_elec_pload")),
            @AttributeOverride(name="emissions.plugLoad.fossilFuelPlugLoads", column = @Column(name="worst_case_emissions_ff_pload")),
            @AttributeOverride(name="emissions.renewable.solarHotWaterGeneration", column = @Column(name="worst_case_emissions_shw_gen")),
            @AttributeOverride(name="emissions.renewable.photovoltaicGeneration", column = @Column(name="worst_case_emissions_photo_gen")),
            @AttributeOverride(name="emissions.renewable.windTurbineGeneration", column = @Column(name="worst_case_emissions_wind_gen")),
            @AttributeOverride(name="emissions.total", column = @Column(name="worst_case_emissions_total"))
    })
    private Disaggregation worstCaseOutcomeAnnualDisaggregation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="cost.hvac.heating", column = @Column(name="likely_case_cost_heat")),
            @AttributeOverride(name="cost.hvac.cooling", column = @Column(name="likely_case_cost_cool")),
            @AttributeOverride(name="cost.hvac.ventilation", column = @Column(name="likely_case_cost_vent")),
            @AttributeOverride(name="cost.hvac.pumps", column = @Column(name="likely_case_cost_pumps")),
            @AttributeOverride(name="cost.hvac.domesticHotWater", column = @Column(name="likely_case_cost_dhw")),
            @AttributeOverride(name="cost.lighting.internalLighting", column = @Column(name="likely_case_cost_int_light")),
            @AttributeOverride(name="cost.lighting.externalLighting", column = @Column(name="likely_case_cost_ext_light")),
            @AttributeOverride(name="cost.plugLoad.electricPlugLoads", column = @Column(name="likely_case_cost_elec_pload")),
            @AttributeOverride(name="cost.plugLoad.fossilFuelPlugLoads", column = @Column(name="likely_case_cost_ff_pload")),
            @AttributeOverride(name="cost.renewable.solarHotWaterGeneration", column = @Column(name="likely_case_cost_shw_gen")),
            @AttributeOverride(name="cost.renewable.photovoltaicGeneration", column = @Column(name="likely_case_cost_photo_gen")),
            @AttributeOverride(name="cost.renewable.windTurbineGeneration", column = @Column(name="likely_case_cost_wind_gen")),
            @AttributeOverride(name="cost.total", column = @Column(name="likely_case_cost_total")),

            @AttributeOverride(name="consumption.hvac.heating", column = @Column(name="likely_case_consumption_heat")),
            @AttributeOverride(name="consumption.hvac.cooling", column = @Column(name="likely_case_consumption_cool")),
            @AttributeOverride(name="consumption.hvac.ventilation", column = @Column(name="likely_case_consumption_vent")),
            @AttributeOverride(name="consumption.hvac.pumps", column = @Column(name="likely_case_consumption_pumps")),
            @AttributeOverride(name="consumption.hvac.domesticHotWater", column = @Column(name="likely_case_consumption_dhw")),
            @AttributeOverride(name="consumption.lighting.internalLighting", column = @Column(name="likely_case_consumption_int_light")),
            @AttributeOverride(name="consumption.lighting.externalLighting", column = @Column(name="likely_case_consumption_ext_light")),
            @AttributeOverride(name="consumption.plugLoad.electricPlugLoads", column = @Column(name="likely_case_consumption_elec_pload")),
            @AttributeOverride(name="consumption.plugLoad.fossilFuelPlugLoads", column = @Column(name="likely_case_consumption_ff_pload")),
            @AttributeOverride(name="consumption.renewable.solarHotWaterGeneration", column = @Column(name="likely_case_consumption_shw_gen")),
            @AttributeOverride(name="consumption.renewable.photovoltaicGeneration", column = @Column(name="likely_case_consumption_photo_gen")),
            @AttributeOverride(name="consumption.renewable.windTurbineGeneration", column = @Column(name="likely_case_consumption_wind_gen")),
            @AttributeOverride(name="consumption.total", column = @Column(name="likely_case_consumption_total")),

            @AttributeOverride(name="emissions.hvac.heating", column = @Column(name="likely_case_emissions_heat")),
            @AttributeOverride(name="emissions.hvac.cooling", column = @Column(name="likely_case_emissions_cool")),
            @AttributeOverride(name="emissions.hvac.ventilation", column = @Column(name="likely_case_emissions_vent")),
            @AttributeOverride(name="emissions.hvac.pumps", column = @Column(name="likely_case_emissions_pumps")),
            @AttributeOverride(name="emissions.hvac.domesticHotWater", column = @Column(name="likely_case_emissions_dhw")),
            @AttributeOverride(name="emissions.lighting.internalLighting", column = @Column(name="likely_case_emissions_int_light")),
            @AttributeOverride(name="emissions.lighting.externalLighting", column = @Column(name="likely_case_emissions_ext_light")),
            @AttributeOverride(name="emissions.plugLoad.electricPlugLoads", column = @Column(name="likely_case_emissions_elec_pload")),
            @AttributeOverride(name="emissions.plugLoad.fossilFuelPlugLoads", column = @Column(name="likely_case_emissions_ff_pload")),
            @AttributeOverride(name="emissions.renewable.solarHotWaterGeneration", column = @Column(name="likely_case_emissions_shw_gen")),
            @AttributeOverride(name="emissions.renewable.photovoltaicGeneration", column = @Column(name="likely_case_emissions_photo_gen")),
            @AttributeOverride(name="emissions.renewable.windTurbineGeneration", column = @Column(name="likely_case_emissions_wind_gen")),
            @AttributeOverride(name="emissions.total", column = @Column(name="likely_case_emissions_total"))
    })
    private Disaggregation mostLikelyOutcomeAnnualDisaggregation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="cost.hvac.heating", column = @Column(name="best_case_cost_heat")),
            @AttributeOverride(name="cost.hvac.cooling", column = @Column(name="best_case_cost_cool")),
            @AttributeOverride(name="cost.hvac.ventilation", column = @Column(name="best_case_cost_vent")),
            @AttributeOverride(name="cost.hvac.pumps", column = @Column(name="best_case_cost_pumps")),
            @AttributeOverride(name="cost.hvac.domesticHotWater", column = @Column(name="best_case_cost_dhw")),
            @AttributeOverride(name="cost.lighting.internalLighting", column = @Column(name="best_case_cost_int_light")),
            @AttributeOverride(name="cost.lighting.externalLighting", column = @Column(name="best_case_cost_ext_light")),
            @AttributeOverride(name="cost.plugLoad.electricPlugLoads", column = @Column(name="best_case_cost_elec_pload")),
            @AttributeOverride(name="cost.plugLoad.fossilFuelPlugLoads", column = @Column(name="best_case_cost_ff_pload")),
            @AttributeOverride(name="cost.renewable.solarHotWaterGeneration", column = @Column(name="best_case_cost_shw_gen")),
            @AttributeOverride(name="cost.renewable.photovoltaicGeneration", column = @Column(name="best_case_cost_photo_gen")),
            @AttributeOverride(name="cost.renewable.windTurbineGeneration", column = @Column(name="best_case_cost_wind_gen")),
            @AttributeOverride(name="cost.total", column = @Column(name="best_case_cost_total")),

            @AttributeOverride(name="consumption.hvac.heating", column = @Column(name="best_case_consumption_heat")),
            @AttributeOverride(name="consumption.hvac.cooling", column = @Column(name="best_case_consumption_cool")),
            @AttributeOverride(name="consumption.hvac.ventilation", column = @Column(name="best_case_consumption_vent")),
            @AttributeOverride(name="consumption.hvac.pumps", column = @Column(name="best_case_consumption_pumps")),
            @AttributeOverride(name="consumption.hvac.domesticHotWater", column = @Column(name="best_case_consumption_dhw")),
            @AttributeOverride(name="consumption.lighting.internalLighting", column = @Column(name="best_case_consumption_int_light")),
            @AttributeOverride(name="consumption.lighting.externalLighting", column = @Column(name="best_case_consumption_ext_light")),
            @AttributeOverride(name="consumption.plugLoad.electricPlugLoads", column = @Column(name="best_case_consumption_elec_pload")),
            @AttributeOverride(name="consumption.plugLoad.fossilFuelPlugLoads", column = @Column(name="best_case_consumption_ff_pload")),
            @AttributeOverride(name="consumption.renewable.solarHotWaterGeneration", column = @Column(name="best_case_consumption_shw_gen")),
            @AttributeOverride(name="consumption.renewable.photovoltaicGeneration", column = @Column(name="best_case_consumption_photo_gen")),
            @AttributeOverride(name="consumption.renewable.windTurbineGeneration", column = @Column(name="best_case_consumption_wind_gen")),
            @AttributeOverride(name="consumption.total", column = @Column(name="best_case_consumption_total")),

            @AttributeOverride(name="emissions.hvac.heating", column = @Column(name="best_case_emissions_heat")),
            @AttributeOverride(name="emissions.hvac.cooling", column = @Column(name="best_case_emissions_cool")),
            @AttributeOverride(name="emissions.hvac.ventilation", column = @Column(name="best_case_emissions_vent")),
            @AttributeOverride(name="emissions.hvac.pumps", column = @Column(name="best_case_emissions_pumps")),
            @AttributeOverride(name="emissions.hvac.domesticHotWater", column = @Column(name="best_case_emissions_dhw")),
            @AttributeOverride(name="emissions.lighting.internalLighting", column = @Column(name="best_case_emissions_int_light")),
            @AttributeOverride(name="emissions.lighting.externalLighting", column = @Column(name="best_case_emissions_ext_light")),
            @AttributeOverride(name="emissions.plugLoad.electricPlugLoads", column = @Column(name="best_case_emissions_elec_pload")),
            @AttributeOverride(name="emissions.plugLoad.fossilFuelPlugLoads", column = @Column(name="best_case_emissions_ff_pload")),
            @AttributeOverride(name="emissions.renewable.solarHotWaterGeneration", column = @Column(name="best_case_emissions_shw_gen")),
            @AttributeOverride(name="emissions.renewable.photovoltaicGeneration", column = @Column(name="best_case_emissions_photo_gen")),
            @AttributeOverride(name="emissions.renewable.windTurbineGeneration", column = @Column(name="best_case_emissions_wind_gen")),
            @AttributeOverride(name="emissions.total", column = @Column(name="best_case_emissions_total"))
    })
    private Disaggregation bestCaseOutcomeAnnualDisaggregation;

    @OneToMany(mappedBy = "measure", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<MeasureInput> inputs;

    @OneToMany(mappedBy = "measure", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @OrderBy("month_of_year")
    private Set<MonthlyMeasureDisaggregation> monthlyDisaggregation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opportunity_id")
    @JsonIgnore
    @JsonBackReference
    private Opportunity opportunity;

    /**
     *
     * @param name the name of this measure
     * @param description the description of this measure
     * @param systemsRetrofitted the systems retrofitted
     * @param subSystemsRetrofitted the sub-systems retrofitted
     * @param buildingOutcome the whole building outcome accounting for interactive effects
     * @param measureOutcome the isolated retrofitted systems outcome ignoring interactive effects
     * @param baselineAnnualDisaggregation the baseline annual disaggregation
     * @param worstCaseOutcomeAnnualDisaggregation the worst case scenario annual disaggregation
     * @param mostLikelyOutcomeAnnualDisaggregation the most likely case scenario annual disaggregation
     * @param bestCaseOutcomeAnnualDisaggregation the best case scenario annual disaggregation
     * @param inputs the list of measures inputs applied
     * @param monthlyDisaggregation the monthly disaggregation
     * @param opportunity the owning opportunity
     */
    public Measure(String name, String description, Set<String> systemsRetrofitted,
                   Set<String> subSystemsRetrofitted, Outcomes buildingOutcome, Outcomes measureOutcome,
                   Disaggregation baselineAnnualDisaggregation,
                   Disaggregation worstCaseOutcomeAnnualDisaggregation,
                   Disaggregation mostLikelyOutcomeAnnualDisaggregation,
                   Disaggregation bestCaseOutcomeAnnualDisaggregation,
                   Set<MeasureInput> inputs,
                   Set<MonthlyMeasureDisaggregation> monthlyDisaggregation,
                   Opportunity opportunity) {
        this.name = name;
        this.description = description;
        this.systemsRetrofitted = systemsRetrofitted;
        this.subSystemsRetrofitted = subSystemsRetrofitted;
        this.buildingOutcome = buildingOutcome;
        this.measureOutcome = measureOutcome;
        this.baselineAnnualDisaggregation = baselineAnnualDisaggregation;
        this.worstCaseOutcomeAnnualDisaggregation = worstCaseOutcomeAnnualDisaggregation;
        this.mostLikelyOutcomeAnnualDisaggregation = mostLikelyOutcomeAnnualDisaggregation;
        this.bestCaseOutcomeAnnualDisaggregation = bestCaseOutcomeAnnualDisaggregation;
        this.inputs = inputs;
        this.monthlyDisaggregation = monthlyDisaggregation;
        this.opportunity = opportunity;
    }

    public Measure setMonthlyDisaggregation(Set<MonthlyMeasureDisaggregation> monthlyDisaggregation) {
        this.monthlyDisaggregation = monthlyDisaggregation;
        return this;
    }

    public Measure setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
        return this;
    }
}
