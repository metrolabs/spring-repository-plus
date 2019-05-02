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
 * patents in processExcelTemplate, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Metro Labs Incorporated.
 */

package com.pivotenergy.model.location;

import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

@NoArgsConstructor
public class GeoLocation {
    private String locale;
    private String postalCode;
    private String locality;
    private String countryCode;
    private String countryName;
    private String regionCode;
    private String regionName;
    private String subRegionCode;
    private String subRegionName;
    private Double latitude;
    private Double longitude;
    private Point point;

    public String getLocale() {
        return locale;
    }

    public GeoLocation setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public GeoLocation setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public GeoLocation setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public GeoLocation setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public GeoLocation setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public GeoLocation setRegionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public GeoLocation setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public String getSubRegionCode() {
        return subRegionCode;
    }

    public GeoLocation setSubRegionCode(String subRegionCode) {
        this.subRegionCode = subRegionCode;
        return this;
    }

    public String getSubRegionName() {
        return subRegionName;
    }

    public GeoLocation setSubRegionName(String subRegionName) {
        this.subRegionName = subRegionName;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public GeoLocation setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public GeoLocation setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Point getPoint() {
        return point;
    }

    public GeoLocation setPoint(Point point) {
        this.point = point;
        return this;
    }

    public String regionKey() {
        return locale + "." + countryCode + "." + regionCode;
    }

    public String subRegionKey() {
        return locale + "." + countryCode + "." + regionCode + "." + subRegionCode;
    }
}
