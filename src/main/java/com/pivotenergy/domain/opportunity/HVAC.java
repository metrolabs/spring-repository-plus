package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class HVAC {
    @Column(name = "heating", nullable = false)
    private Double heating;
    @Column(name = "cooling", nullable = false)
    private Double cooling;
    @Column(name = "ventilation", nullable = false)
    private Double ventilation;
    @Column(name = "pumps", nullable = false)
    private Double pumps;
    @Column(name = "domestic_hot_water", nullable = false)
    private Double domesticHotWater;

    public HVAC(Double heating, Double cooling, Double ventilation, Double pumps, Double domesticHotWater) {
        this.heating = heating;
        this.cooling = cooling;
        this.ventilation = ventilation;
        this.pumps = pumps;
        this.domesticHotWater = domesticHotWater;
    }

    public Double getHeating() {
        return heating;
    }

    public Double getCooling() {
        return cooling;
    }

    public Double getVentilation() {
        return ventilation;
    }

    public Double getPumps() {
        return pumps;
    }

    public Double getDomesticHotWater() {
        return domesticHotWater;
    }

    @Transient
    public Double getTotal() {
        return heating + cooling + ventilation + pumps + domesticHotWater;
    }
}
