package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class TenantImpactType {
    @Column(name = "tenant_impact_name", length = 128)
    private String name;

    @Column(name = "tenant_impact_score")
    private Double score;

    public TenantImpactType(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public TenantImpactType setName(String name) {
        this.name = name;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public TenantImpactType setScore(Double score) {
        this.score = score;
        return this;
    }
}
