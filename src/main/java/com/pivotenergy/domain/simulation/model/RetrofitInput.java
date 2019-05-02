package com.pivotenergy.domain.simulation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrofitInput {
    protected String id;
    protected String key;
    protected String system;
    protected String component;
    protected Object retrofitValue;
    protected Object baselineValue;
}
