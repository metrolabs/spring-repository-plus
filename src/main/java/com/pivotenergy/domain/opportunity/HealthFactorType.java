package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class HealthFactorType {
    @Column(name = "health_factor_name", length = 128)
    private String name;

    @Column(name = "health_factor_score")
    private Double score;

    public HealthFactorType(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public HealthFactorType setName(String name) {
        this.name = name;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public HealthFactorType setScore(Double score) {
        this.score = score;
        return this;
    }
}
