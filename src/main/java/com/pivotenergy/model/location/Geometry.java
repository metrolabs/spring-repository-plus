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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by wgayton on 1/23/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class Geometry {
    /**
     * {@code bounds} (optionally returned) stores the bounding box which can fully contain the
     * returned result. Note that these bounds may not match the recommended viewport. (For example,
     * San Francisco includes the Farallon islands, which are technically part of the city, but
     * probably should not be returned in the viewport.)
     */
    public Bounds bounds;

    /**
     * {@code location} contains the geocoded {@code latitude,longitude} value. For normal address
     * lookups, this field is typically the most important.
     */
    public LatLng location;

    /**
     * The level of certainty of this geocoding result.
     */
    public LocationType locationType;

    /**
     * {@code viewport} contains the recommended viewport for displaying the returned result.
     * Generally the viewport is used to frame a result when displaying it to a user.
     */
    public Bounds viewport;

    public enum LocationType {
        /**
         * {@code ROOFTOP} restricts the results to addresses for which we have location information
         * accurate down to street address precision.
         */
        ROOFTOP,

        /**
         * {@code RANGE_INTERPOLATED} restricts the results to those that reflect an approximation
         * (usually on a road) interpolated between two precise points (such as intersections). An
         * interpolated range generally indicates that rooftop geocodes are unavailable for a street
         * address.
         */
        RANGE_INTERPOLATED,

        /**
         * {@code GEOMETRIC_CENTER} restricts the results to geometric centers of a location such as a
         * polyline (for example, a street) or polygon (region).
         */
        GEOMETRIC_CENTER,

        /**
         * {@code APPROXIMATE} restricts the results to those that are characterized as approximate.
         */
        APPROXIMATE,

        /**
         * Indicates an unknown location type returned by the server. The Java Client for Google Maps
         * Services should be updated to support the new value.
         */
        UNKNOWN
    }
}
