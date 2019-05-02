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
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Timestamp;

@SuppressWarnings({"unused", "WeakerAccess"})
@Entity
@NoArgsConstructor
@EntityListeners(SecurityAuditorAware.class)
public class MeasurementRawReading extends MultiTenantBaseEntity<MeasurementRawReading> {
    @Id
    @Column(name = "id", nullable = false, length = 128)
    @GeneratedValue(generator="MeasurableIdGenerator")
    @GenericGenerator(name="MeasurableIdGenerator", strategy="com.pivotenergy.domain.measurable.MeasurableIdGenerator")
    private String id;

    @NotNull
    @Column(name = "`year`", nullable = false)
    private Integer year;

    @NotNull
    @Range(min = 1, max = 12)
    @Column(name = "`month`", nullable = false)
    private Integer month;

    @NotNull
    @Range(min = 1, max = 31)
    @Column(name = "`day`", nullable = false)
    private Integer day;

    @NotNull
    @Range(min = 1, max = 24)
    @Column(name = "`hour`", nullable = false)
    private Integer hour;

    @NotNull
    @Range(min = 1, max = 60)
    @Column(name = "`minute`", nullable = false)
    private Integer minute;
    /**
     * Duration measurement period in minutes
     */
    @NotNull
    @Column(name = "`duration`", nullable = false)
    private Integer duration;
    /**
     * The timestamp marking the time this system processed and persisted this event
     */
    @Past
    @NotNull
    @Column(name = "`measured_at`", nullable = false)
    private Timestamp measuredAt;

    @NotNull
    @Column(name = "`consumption_base_unit`", nullable = false)
    private Double consumptionBaseUnit;

    @Column(name = "cost", precision = 4)
    private Double cost;

    @Column(name = "consumption_kwh", precision = 4)
    private Double consumptionKWH;

    @Column(name = "emissions_kg", precision = 4)
    private Double emissionsKg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`measurable_id`", referencedColumnName = "`id`", insertable = false, updatable = false)
    @JsonIgnore
    private Measurable measurable;

    public MeasurementRawReading(Integer year, Integer month, Integer day, Integer hour, Integer minute,
                                 Integer duration, Timestamp measuredAt, Double consumptionBaseUnit, Double cost,
                                 Double consumptionKWH, Double emissionsKg, Measurable measurable) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.duration = duration;
        this.measuredAt = measuredAt;
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
    public MeasurementRawReading setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public MeasurementRawReading setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMonth() {
        return month;
    }

    public MeasurementRawReading setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public Integer getDay() {
        return day;
    }

    public MeasurementRawReading setDay(Integer day) {
        this.day = day;
        return this;
    }

    public Integer getHour() {
        return hour;
    }

    public MeasurementRawReading setHour(Integer hour) {
        this.hour = hour;
        return this;
    }

    public Integer getMinute() {
        return minute;
    }

    public MeasurementRawReading setMinute(Integer minute) {
        this.minute = minute;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public MeasurementRawReading setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Timestamp getMeasuredAt() {
        return measuredAt;
    }

    public MeasurementRawReading setMeasuredAt(Timestamp measuredAt) {
        this.measuredAt = measuredAt;
        return this;
    }

    public Double getConsumptionBaseUnit() {
        return consumptionBaseUnit;
    }

    public MeasurementRawReading setConsumptionBaseUnit(Double consumptionBaseUnit) {
        this.consumptionBaseUnit = consumptionBaseUnit;
        return this;
    }

    public Double getCost() {
        return cost;
    }

    public MeasurementRawReading setCost(Double cost) {
        this.cost = cost;
        return this;
    }

    public Double getConsumptionKWH() {
        return consumptionKWH;
    }

    public MeasurementRawReading setConsumptionKWH(Double consumptionKWH) {
        this.consumptionKWH = consumptionKWH;
        return this;
    }

    public Double getEmissionsKg() {
        return emissionsKg;
    }

    public MeasurementRawReading setEmissionsKg(Double emissionsKg) {
        this.emissionsKg = emissionsKg;
        return this;
    }

    public Measurable getMeasurable() {
        return measurable;
    }

    public MeasurementRawReading setMeasurable(Measurable measurable) {
        this.measurable = measurable;
        return this;
    }
}