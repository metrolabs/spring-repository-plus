package com.pivotenergy.domain.opportunity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pivotenergy.domain.MultiTenantBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@SuppressWarnings("unused")
@Entity
@Getter
@NoArgsConstructor
public class MonthlyMeasureDisaggregation extends MultiTenantBaseEntity<MonthlyMeasureDisaggregation> {
    @NotNull
    @Range(min = 1, max = 12)
    @Column(name="month_of_year")
    private Integer month;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measure_id")
    @JsonIgnore
    @JsonBackReference
    private Measure measure;

    /**
     *
     * @param month the month of year
     * @param baselineAnnualDisaggregation the baseline annual disaggregation
     * @param worstCaseOutcomeAnnualDisaggregation the worst case scenario annual disaggregation
     * @param mostLikelyOutcomeAnnualDisaggregation the most likely case scenario annual disaggregation
     * @param bestCaseOutcomeAnnualDisaggregation the best case scenario annual disaggregation
     * @param measure the parent measure
     */
    public MonthlyMeasureDisaggregation(Integer month,
                                        Disaggregation baselineAnnualDisaggregation,
                                        Disaggregation worstCaseOutcomeAnnualDisaggregation,
                                        Disaggregation mostLikelyOutcomeAnnualDisaggregation,
                                        Disaggregation bestCaseOutcomeAnnualDisaggregation,
                                        Measure measure) {
        this.month = month;
        this.measure = measure;
        this.baselineAnnualDisaggregation = baselineAnnualDisaggregation;
        this.worstCaseOutcomeAnnualDisaggregation = worstCaseOutcomeAnnualDisaggregation;
        this.mostLikelyOutcomeAnnualDisaggregation = mostLikelyOutcomeAnnualDisaggregation;
        this.bestCaseOutcomeAnnualDisaggregation = bestCaseOutcomeAnnualDisaggregation;
    }
}
