package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class InfrastructureImpactType {
    @Basic
    @Column(name = "infrastructure_impact_name", nullable = false, length = 128)
    private String name;
    @Basic
    @Column(name = "infrastructure_impact_score", nullable = false)
    private Double score;

    public InfrastructureImpactType(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public InfrastructureImpactType setName(String name) {
        this.name = name;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public InfrastructureImpactType setScore(Double score) {
        this.score = score;
        return this;
    }
}
