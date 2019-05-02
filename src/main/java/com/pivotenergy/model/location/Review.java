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

import java.net.URL;

@Getter
@Setter
@NoArgsConstructor
public class Review {

    /**
     * aspects contains a collection of AspectRating objects, each of which provides a rating of a
     * single attribute of the establishment.
     *
     * <p>Note: this is a <a href="https://developers.google.com/places/web-service/details#PremiumData">Premium
     * Data</a> field available to the Google Places API for Work customers.</p>
     */
    public AspectRating[] aspects;

    /**
     * authorName the name of the user who submitted the review. Anonymous reviews are attributed to
     * "A Google user".
     */
    public String authorName;

    /**
     * authorUrl the URL to the users Google+ profile, if available.
     */
    public URL authorUrl;

    /**
     * language an IETF language code indicating the language used in the user's review.
     */
    public String language;

    /**
     * rating the user's overall rating for this place. This is a whole number, ranging from 1 to
     * 5.
     */
    public int rating;

    /**
     * text is the user's review. When reviewing a location with Google Places, text reviews are
     * considered optional.
     */
    public String text;

    /**
     * time is the time that the review was submitted, as seconds since epoch.
     */
    public Object time;

    public class AspectRating {
        /**
         * type is the name of the aspect that is being rated.
         */
        public RatingType type;

        /**
         * rating is the user's rating for this particular aspect, from 0 to 3.
         */
        public int rating;
    }

    public enum RatingType {
        APPEAL, ATMOSPHERE, DECOR, FACILITIES, FOOD, OVERALL, QUALITY, SERVICE,

        /**
         * Indicates an unknown rating type returned by the server. The Java Client for Google Maps
         * Services should be updated to support the new value.
         */
        UNKNOWN
    }
}
