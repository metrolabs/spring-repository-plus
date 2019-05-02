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

package com.pivotenergy.domain.measurable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pivotenergy.domain.MultiTenantBaseEntity;
import com.pivotenergy.domain.SecurityAuditorAware;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@SuppressWarnings({"unused", "WeakerAccess"})
@Entity
@NoArgsConstructor
@EntityListeners(SecurityAuditorAware.class)
public class MeasurementYearly extends MultiTenantBaseEntity<MeasurementYearly> {
    @Id
    @Column(name = "id", nullable = false, length = 128)
    @GeneratedValue(generator="MeasurableIdGenerator")
    @GenericGenerator(name="MeasurableIdGenerator", strategy="com.pivotenergy.domain.measurable.MeasurableIdGenerator")
    private String id;

    @NotNull
    @Column(name = "`year`", nullable = false)
    private Integer year;

    @NotNull
    @Column(name = "`consumption_base_unit`", nullable = false)
    private Double consumptionBaseUnit;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "consumption_kwh")
    private Double consumptionKWH;

    @Column(name = "emissions_kg")
    private Double emissionsKg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`measurable_id`", referencedColumnName = "`id`", insertable = false, updatable = false)
    @JsonIgnore
    private Measurable measurable;

    public MeasurementYearly(Integer year, Double consumptionBaseUnit, Double cost, Double consumptionKWH,
                             Double emissionsKg, Measurable measurable) {
        this.year = year;
        this.consumptionBaseUnit = consumptionBaseUnit;
        this.cost = cost;
        this.consumptionKWH = consumptionKWH;
        this.emissionsKg = emissionsKg;
        this.measurable = measurable;
        this.id = MeasurableIdGenerator.generateId(this);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public MeasurementYearly setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public MeasurementYearly setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Double getConsumptionBaseUnit() {
        return consumptionBaseUnit;
    }

    public MeasurementYearly setConsumptionBaseUnit(Double consumptionBaseUnit) {
        this.consumptionBaseUnit = consumptionBaseUnit;
        return this;
    }

    public Double getCost() {
        return cost;
    }

    public MeasurementYearly setCost(Double cost) {
        this.cost = cost;
        return this;
    }

    public Double getConsumptionKWH() {
        return consumptionKWH;
    }

    public MeasurementYearly setConsumptionKWH(Double consumptionKWH) {
        this.consumptionKWH = consumptionKWH;
        return this;
    }

    public Double getEmissionsKg() {
        return emissionsKg;
    }

    public MeasurementYearly setEmissionsKg(Double emissionsKg) {
        this.emissionsKg = emissionsKg;
        return this;
    }

    public Measurable getMeasurable() {
        return measurable;
    }

    public MeasurementYearly setMeasurable(Measurable measurable) {
        this.measurable = measurable;
        return this;
    }
}
