package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class Renewable {
    @Column(name = "solar_hot_water_generation", nullable = false)
    private Double solarHotWaterGeneration;
    @Column(name = "photovoltaic_generation", nullable = false)
    private Double photovoltaicGeneration;
    @Column(name = "wind_turbine_generation", nullable = false)
    private Double windTurbineGeneration;

    public Renewable(Double solarHotWaterGeneration, Double photovoltaicGeneration, Double windTurbineGeneration) {
        this.solarHotWaterGeneration = solarHotWaterGeneration;
        this.photovoltaicGeneration = photovoltaicGeneration;
        this.windTurbineGeneration = windTurbineGeneration;
    }

    public Double getSolarHotWaterGeneration() {
        return solarHotWaterGeneration;
    }

    public Double getPhotovoltaicGeneration() {
        return photovoltaicGeneration;
    }

    public Double getWindTurbineGeneration() {
        return windTurbineGeneration;
    }

    @Transient
    public Double getTotal() {
        return solarHotWaterGeneration + photovoltaicGeneration + windTurbineGeneration;
    }
}
