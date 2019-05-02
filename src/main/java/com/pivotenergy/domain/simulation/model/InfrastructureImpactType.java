package com.pivotenergy.domain.simulation.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("unused")
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfrastructureImpactType {
    protected String id;
    protected String name;
    protected Double score;
}