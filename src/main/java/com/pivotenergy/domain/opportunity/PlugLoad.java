package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class PlugLoad {
    @Column(name = "electric_plug_loads", nullable = false)
    private Double electricPlugLoads;
    @Column(name = "fossil_fuel_plug_loads", nullable = false)
    private Double fossilFuelPlugLoads;

    public PlugLoad(Double electricPlugLoads, Double fossilFuelPlugLoads) {
        this.electricPlugLoads = electricPlugLoads;
        this.fossilFuelPlugLoads = fossilFuelPlugLoads;
    }

    public Double getElectricPlugLoads() {
        return electricPlugLoads;
    }

    public Double getFossilFuelPlugLoads() {
        return fossilFuelPlugLoads;
    }

    @Transient
    public Double getTotal() {
        return electricPlugLoads + fossilFuelPlugLoads;
    }
}
