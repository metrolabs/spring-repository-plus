package com.pivotenergy.domain.opportunity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("unused")
@Embeddable
@Getter
@NoArgsConstructor
public class Disaggregation {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="hvac.heating", column = @Column(name="cost_heat")),
            @AttributeOverride(name="hvac.cooling", column = @Column(name="cost_cool")),
            @AttributeOverride(name="hvac.ventilation", column = @Column(name="cost_vent")),
            @AttributeOverride(name="hvac.pumps", column = @Column(name="cost_pumps")),
            @AttributeOverride(name="hvac.domesticHotWater", column = @Column(name="cost_dhw")),
            @AttributeOverride(name="lighting.internalLighting", column = @Column(name="cost_int_light")),
            @AttributeOverride(name="lighting.externalLighting", column = @Column(name="cost_ext_light")),
            @AttributeOverride(name="plugLoad.electricPlugLoads", column = @Column(name="cost_elec_pload")),
            @AttributeOverride(name="plugLoad.fossilFuelPlugLoads", column = @Column(name="cost_ff_pload")),
            @AttributeOverride(name="renewable.solarHotWaterGeneration", column = @Column(name="cost_shw_gen")),
            @AttributeOverride(name="renewable.photovoltaicGeneration", column = @Column(name="cost_photo_gen")),
            @AttributeOverride(name="renewable.windTurbineGeneration", column = @Column(name="cost_wind_gen")),
            @AttributeOverride(name="total", column = @Column(name="cost_total"))
    })
    private SummaryAnnual cost;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="hvac.heating", column = @Column(name="consumption_heat")),
            @AttributeOverride(name="hvac.cooling", column = @Column(name="consumption_cool")),
            @AttributeOverride(name="hvac.ventilation", column = @Column(name="consumption_vent")),
            @AttributeOverride(name="hvac.pumps", column = @Column(name="consumption_pumps")),
            @AttributeOverride(name="hvac.domesticHotWater", column = @Column(name="consumption_dhw")),
            @AttributeOverride(name="lighting.internalLighting", column = @Column(name="consumption_int_light")),
            @AttributeOverride(name="lighting.externalLighting", column = @Column(name="consumption_ext_light")),
            @AttributeOverride(name="plugLoad.electricPlugLoads", column = @Column(name="consumption_elec_pload")),
            @AttributeOverride(name="plugLoad.fossilFuelPlugLoads", column = @Column(name="consumption_ff_pload")),
            @AttributeOverride(name="renewable.solarHotWaterGeneration", column = @Column(name="consumption_shw_gen")),
            @AttributeOverride(name="renewable.photovoltaicGeneration", column = @Column(name="consumption_photo_gen")),
            @AttributeOverride(name="renewable.windTurbineGeneration", column = @Column(name="consumption_wind_gen")),
            @AttributeOverride(name="total", column = @Column(name="consumption_total"))
    })
    private SummaryAnnual consumption;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="hvac.heating", column = @Column(name="emissions_heat")),
            @AttributeOverride(name="hvac.cooling", column = @Column(name="emissions_cool")),
            @AttributeOverride(name="hvac.ventilation", column = @Column(name="emissions_vent")),
            @AttributeOverride(name="hvac.pumps", column = @Column(name="emissions_pumps")),
            @AttributeOverride(name="hvac.domesticHotWater", column = @Column(name="emissions_dhw")),
            @AttributeOverride(name="lighting.internalLighting", column = @Column(name="emissions_int_light")),
            @AttributeOverride(name="lighting.externalLighting", column = @Column(name="emissions_ext_light")),
            @AttributeOverride(name="plugLoad.electricPlugLoads", column = @Column(name="emissions_elec_pload")),
            @AttributeOverride(name="plugLoad.fossilFuelPlugLoads", column = @Column(name="emissions_ff_pload")),
            @AttributeOverride(name="renewable.solarHotWaterGeneration", column = @Column(name="emissions_shw_gen")),
            @AttributeOverride(name="renewable.photovoltaicGeneration", column = @Column(name="emissions_photo_gen")),
            @AttributeOverride(name="renewable.windTurbineGeneration", column = @Column(name="emissions_wind_gen")),
            @AttributeOverride(name="total", column = @Column(name="emissions_total"))
    })
    private SummaryAnnual emissions;

    /**
     *
     * @param cost cost summary
     * @param consumption consumption summary
     * @param emissions emissions summary
     */
    public Disaggregation(SummaryAnnual cost, SummaryAnnual consumption, SummaryAnnual emissions) {
        this.cost = cost;
        this.consumption = consumption;
        this.emissions = emissions;
    }
}
