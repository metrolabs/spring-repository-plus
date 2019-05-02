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

import com.pivotenergy.domain.BaseEntity;
import com.pivotenergy.domain.SecurityAuditorAware;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.Past;
import java.util.Date;


@SuppressWarnings("unused")
@Entity
@NoArgsConstructor
@EntityListeners(SecurityAuditorAware.class)
public class ClimateDataMonthly extends BaseEntity<ClimateDataMonthly> {
    @Id
    @Column(name = "id", nullable = false, length = 128)
    private String id;

    @NotBlank
    @Column(name = "station_id", nullable = false, length = 128)
    private String stationId;

    @Past
    @NotBlank
    @Column(name = "observation_date", nullable = false)
    private Date observationDate;

    @NotBlank
    @Column(name = "observation_year", nullable = false)
    private Integer observationYear;

    @NotBlank
    @Column(name = "observation_month", nullable = false)
    private Integer observationMonth;

    @NotBlank
    @Column(name = "air_temp_celsius", nullable = false, precision = 2)
    private Double airTempCelsius;

    @NotBlank
    @Column(name = "air_temp_fahrenheit", nullable = false, precision = 2)
    private Double airTempFahrenheit;

    @Column(name = "data_source", length = 128)
    private String dataSource;


    @Override
    public String getId() {
        return id;
    }

    @Override
    public ClimateDataMonthly setId(String id) {
        this.id = id;
        return this;
    }

    public String getStationId() {
        return stationId;
    }

    public ClimateDataMonthly setStationId(String stationId) {
        this.stationId = stationId;
        return this;
    }

    public Date getObservationDate() {
        return observationDate;
    }

    public ClimateDataMonthly setObservationDate(Date observationDate) {
        this.observationDate = observationDate;
        return this;
    }

    public Integer getObservationYear() {
        return observationYear;
    }

    public ClimateDataMonthly setObservationYear(Integer observationYear) {
        this.observationYear = observationYear;
        return this;
    }

    public Integer getObservationMonth() {
        return observationMonth;
    }

    public ClimateDataMonthly setObservationMonth(Integer observationMonth) {
        this.observationMonth = observationMonth;
        return this;
    }

    public Double getAirTempCelsius() {
        return airTempCelsius;
    }

    public ClimateDataMonthly setAirTempCelsius(Double airTempCelsius) {
        this.airTempCelsius = airTempCelsius;
        return this;
    }

    public Double getAirTempFahrenheit() {
        return airTempFahrenheit;
    }

    public ClimateDataMonthly setAirTempFahrenheit(Double airTempFahrenheit) {
        this.airTempFahrenheit = airTempFahrenheit;
        return this;
    }

    public String getDataSource() {
        return dataSource;
    }

    public ClimateDataMonthly setDataSource(String dataSource) {
        this.dataSource = dataSource;
        return this;
    }
}
