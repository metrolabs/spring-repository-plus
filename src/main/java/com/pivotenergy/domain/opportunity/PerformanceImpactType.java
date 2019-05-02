package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class PerformanceImpactType {
    @Basic
    @Column(name = "performance_impact_name", nullable = false, length = 128)
    private String name;
    @Basic
    @Column(name = "performance_impact_name_lower_score", nullable = false)
    private Double lowerScore;
    @Basic
    @Column(name = "performance_impact_name_upper_score", nullable = false)
    private Double upperScore;

    public PerformanceImpactType(String name, Double lowerScore, Double upperScore) {
        this.name = name;
        this.lowerScore = lowerScore;
        this.upperScore = upperScore;
    }

    public String getName() {
        return name;
    }

    public PerformanceImpactType setName(String name) {
        this.name = name;
        return this;
    }

    public Double getLowerScore() {
        return lowerScore;
    }

    public PerformanceImpactType setLowerScore(Double lowerScore) {
        this.lowerScore = lowerScore;
        return this;
    }

    public Double getUpperScore() {
        return upperScore;
    }

    public PerformanceImpactType setUpperScore(Double upperScore) {
        this.upperScore = upperScore;
        return this;
    }
}
