package com.pivotenergy.domain.simulation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Acceptance implements Serializable {
    protected boolean accepted;
    protected String fieldId;
    protected String fieldName;
    protected String measureId;
    protected Object baselineValue;
    protected Object retrofitValue;
    protected String acceptanceCondition;
    protected String acceptanceFormula;
    protected double measureCost;
    protected String exception;
}
