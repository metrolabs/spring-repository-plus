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
import com.pivotenergy.model.measurable.ClimateZones;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@SuppressWarnings("unused")
@Document
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClimateZone {

    @Id
    private String id;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;
    private ClimateZones koppen;
    private String ashrae;
    @Transient
    private Distance distance;

    public String getId() {
        return id;
    }

    public ClimateZone setId(String id) {
        this.id = id;
        return this;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public ClimateZone setLocation(GeoJsonPoint location) {
        this.location = location;
        return this;
    }

    public ClimateZones getKoppen() {
        return koppen;
    }

    public ClimateZone setKoppen(ClimateZones koppen) {
        this.koppen = koppen;
        return this;
    }

    public String getAshrae() {
        return ashrae;
    }

    public ClimateZone setAshrae(String ashrae) {
        this.ashrae = ashrae;
        return this;
    }

    public Distance getDistance() {
        return distance;
    }

    public ClimateZone setDistance(Distance distance) {
        this.distance = distance;
        return this;
    }
}
