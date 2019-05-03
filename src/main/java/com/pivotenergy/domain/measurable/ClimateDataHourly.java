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
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Past;
import java.util.Date;

@SuppressWarnings("unused")
@Entity
@NoArgsConstructor
public class ClimateDataHourly extends BaseEntity<ClimateDataHourly> {
    @org.springframework.data.annotation.Id
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

    @Column(name = "observation_day", nullable = false)
    private Integer observationDay;

    @Column(name = "observation_hour", nullable = false)
    private Integer observationHour;

    @NotBlank
    @Column(name = "air_temp_celsius", nullable = false, precision = 2)
    private Double airTempCelsius;

    @NotBlank
    @Column(name = "air_temp_fahrenheit", nullable = false, precision = 2)
    private Double airTempFahrenheit;

    @Column(name = "data_source", length = 128)
    private String dataSource;

    public ClimateDataHourly(String id, String stationId, Date observationDate, int observationYear,
                             int observationMonth, int observationDay, int observationHour,
                             double airTempCelsius, double airTempFahrenheit, String dataSource) {
        this.id = id;
        this.stationId = stationId;
        this.observationDate = observationDate;
        this.observationYear = observationYear;
        this.observationMonth = observationMonth;
        this.observationDay = observationDay;
        this.observationHour = observationHour;
        this.airTempCelsius = airTempCelsius;
        this.airTempFahrenheit = airTempFahrenheit;
        this.dataSource = dataSource;
    }

    public String getStationId() {
        return stationId;
    }

    public ClimateDataHourly setStationId(String stationId) {
        this.stationId = stationId;
        return this;
    }

    public Date getObservationDate() {
        return observationDate;
    }

    public ClimateDataHourly setObservationDate(Date observationDate) {
        this.observationDate = observationDate;
        return this;
    }

    public Integer getObservationYear() {
        return observationYear;
    }

    public ClimateDataHourly setObservationYear(Integer observationYear) {
        this.observationYear = observationYear;
        return this;
    }

    public Integer getObservationMonth() {
        return observationMonth;
    }

    public ClimateDataHourly setObservationMonth(Integer observationMonth) {
        this.observationMonth = observationMonth;
        return this;
    }

    public Integer getObservationDay() {
        return observationDay;
    }

    public ClimateDataHourly setObservationDay(Integer observationDay) {
        this.observationDay = observationDay;
        return this;
    }

    public Integer getObservationHour() {
        return observationHour;
    }

    public ClimateDataHourly setObservationHour(Integer observationHour) {
        this.observationHour = observationHour;
        return this;
    }

    public Double getAirTempCelsius() {
        return airTempCelsius;
    }

    public ClimateDataHourly setAirTempCelsius(Double airTempCelsius) {
        this.airTempCelsius = airTempCelsius;
        return this;
    }

    public Double getAirTempFahrenheit() {
        return airTempFahrenheit;
    }

    public ClimateDataHourly setAirTempFahrenheit(Double airTempFahrenheit) {
        this.airTempFahrenheit = airTempFahrenheit;
        return this;
    }

    public String getDataSource() {
        return dataSource;
    }

    public ClimateDataHourly setDataSource(String dataSource) {
        this.dataSource = dataSource;
        return this;
    }
}
