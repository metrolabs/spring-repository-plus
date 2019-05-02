/*
 * ________________________________________________________________________
 * METRO.IO CONFIDENTIAL
 * ________________________________________________________________________
 *
 * Copyright (c) 2017.
 * Metro Labs Incorporated
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains
 * the property of Metro Labs Incorporated and its suppliers,
 * if any. The intellectual and technical concepts contained
 * herein are proprietary to Metro Labs Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Metro Labs Incorporated.
 */

package com.pivotenergy.domain.opportunity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pivotenergy.domain.MultiTenantBaseEntity;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasureInput extends MultiTenantBaseEntity<MeasureInput> {
    @NotBlank
    @Column(name = "input_id", nullable = false, length = 128)
    private String inputId;

    @NotBlank
    @Column(name = "input_key", nullable = false, length = 128)
    private String inputKey;

    @NotBlank
    @Column(name = "prior_value", nullable = false, length = 256)
    private String priorValue;

    @NotBlank
    @Column(name = "retrofit_value", nullable = false, length = 256)
    private String retrofitValue;

    @NotBlank
    @Column(name = "model_system", nullable = false, length = 128)
    private String modelSystem;

    @Column(name = "model_component", nullable = false, length = 128)
    private String modelComponent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measure_id")
    @JsonIgnore
    private Measure measure;

    /**
     *
     * @param inputId the models unique input id
     * @param priorValue the pre-retrofit model value
     * @param retrofitValue the post-retrofit model value
     * @param modelSystem the system retrofitted
     * @param modelComponent the sub-system retrofitted
     * @param inputKey the models canonical name of the input
     * @param measure the measure this input is a part of
     */
    public MeasureInput(String inputId, String inputKey, String priorValue, String retrofitValue, String modelSystem,
                        String modelComponent, Measure measure) {
        this.inputId = inputId;
        this.priorValue = priorValue;
        this.retrofitValue = retrofitValue;
        this.modelSystem = modelSystem;
        this.modelComponent = modelComponent;
        this.inputKey = inputKey;
        this.measure = measure;
    }

    public String getInputId() {
        return inputId;
    }

    public String getInputKey() {
        return inputKey;
    }

    public String getPriorValue() {
        return priorValue;
    }

    public String getRetrofitValue() {
        return retrofitValue;
    }

    public String getModelSystem() {
        return modelSystem;
    }

    public String getModelComponent() {
        return modelComponent;
    }

    public Measure getMeasure() {
        return measure;
    }
}
