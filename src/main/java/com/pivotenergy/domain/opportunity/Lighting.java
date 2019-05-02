package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class Lighting {
    @Column(name = "internal_lighting", nullable = false)
    private Double internalLighting;
    @Column(name = "external_lighting", nullable = false)
    private Double externalLighting;

    public Lighting(Double internalLighting, Double externalLighting) {
        this.internalLighting = internalLighting;
        this.externalLighting = externalLighting;
    }

    public Double getInternalLighting() {
        return internalLighting;
    }

    public Double getExternalLighting() {
        return externalLighting;
    }

    @Transient
    public Double getTotal() {
        return externalLighting + internalLighting;
    }
}
