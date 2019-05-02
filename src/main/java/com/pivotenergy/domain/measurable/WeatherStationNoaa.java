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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@SuppressWarnings("unused")
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherStationNoaa {
    @Id
    private String id;
    private String usaf;
    private String wban;
    private String stationName;
    private String country;
    private String region;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;
    private Date inventoryStart;
    private Date inventoryEnd;
    private long inventoryYears;
    private int inventoryStartYear;
    private int inventoryEndYear;
    @Transient
    private Distance distance;

    public String getId() {
        return id;
    }

    public WeatherStationNoaa setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsaf() {
        return usaf;
    }

    public WeatherStationNoaa setUsaf(String usaf) {
        this.usaf = usaf;
        return this;
    }

    public String getWban() {
        return wban;
    }

    public WeatherStationNoaa setWban(String wban) {
        this.wban = wban;
        return this;
    }

    public String getStationName() {
        return stationName;
    }

    public WeatherStationNoaa setStationName(String stationName) {
        this.stationName = stationName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public WeatherStationNoaa setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public WeatherStationNoaa setRegion(String region) {
        this.region = region;
        return this;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public WeatherStationNoaa setLocation(GeoJsonPoint location) {
        this.location = location;
        return this;
    }

    public Date getInventoryStart() {
        return inventoryStart;
    }

    public WeatherStationNoaa setInventoryStart(Date inventoryStart) {
        this.inventoryStart = inventoryStart;
        return this;
    }

    public Date getInventoryEnd() {
        return inventoryEnd;
    }

    public WeatherStationNoaa setInventoryEnd(Date inventoryEnd) {
        this.inventoryEnd = inventoryEnd;
        return this;
    }

    public long getInventoryYears() {
        return inventoryYears;
    }

    public WeatherStationNoaa setInventoryYears(long inventoryYears) {
        this.inventoryYears = inventoryYears;
        return this;
    }

    public int getInventoryStartYear() {
        return inventoryStartYear;
    }

    public WeatherStationNoaa setInventoryStartYear(int inventoryStartYear) {
        this.inventoryStartYear = inventoryStartYear;
        return this;
    }

    public int getInventoryEndYear() {
        return inventoryEndYear;
    }

    public WeatherStationNoaa setInventoryEndYear(int inventoryEndYear) {
        this.inventoryEndYear = inventoryEndYear;
        return this;
    }

    public Distance getDistance() {
        return distance;
    }

    public WeatherStationNoaa setDistance(Distance distance) {
        this.distance = distance;
        return this;
    }
}
