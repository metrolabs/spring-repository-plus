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
public class LocationDetails {
    /**
     * addressComponents is a list of separate address components used to compose a given address.
     */
    public AddressComponent[] addressComponents;

    /**
     * formattedAddress is a string containing the human-readable address of this place.
     */
    public String formattedAddress;

    /**
     * formattedPhoneNumber contains the place's phone number in its local format.
     */
    public String formattedPhoneNumber;

    /**
     * geometry is the location of the Place.
     */
    public Geometry geometry;

    /**
     * icon contains the URL of a suggested icon which may be displayed to the user when indicating
     * this result on a map.
     */
    public URL icon;

    /**
     * internationalPhoneNumber contains the place's phone number in international format.
     * International format includes the country code, and is prefixed with the plus (+) sign.
     */
    public String internationalPhoneNumber;

    /**
     * name contains the human-readable name for the returned result.
     */
    public String name;

    /**
     * The opening hours for the place.
     */
    public OpeningHours openingHours;

    /**
     * photos is a list of photo objects, each containing a reference to an image.
     */
    public Photo[] photos;

    /**
     * placeId is a textual identifier that uniquely identifies a place.
     */
    public String placeId;

    /**
     * scope: Indicates the scope of the placeId.
     */
    public PlaceIdScope scope;

    /**
     * altIds is an optional array of alternative place IDs for the place, with a scope related to
     * each alternative ID.
     */
    public AlternatePlaceIds[] altIds;

    /**
     * priceLevel is the price level of the place. The exact amount indicated by a specific value will
     * vary from region to region.
     */
    public PriceLevel priceLevel;

    /**
     * rating contains the place's rating, from 1.0 to 5.0, based on aggregated user reviews.
     */
    public float rating;

    /**
     * reviews is an array of up to five reviews. If a language parameter was specified in the Place
     * Details request, the Places Service will bias the results to prefer reviews written in that
     * language.
     */
    public Review[] reviews;

    /**
     * types contains an array of feature types describing the given result.
     */
    public String[] types;

    /**
     * url contains the URL of the official Google page for this place. This will be the
     * establishment's Google+ page if the Google+ page exists, otherwise it will be the Google-owned
     * page that contains the best available information about the place. Applications must link to or
     * embed this page on any screen that shows detailed results about the place to the user.
     */
    public URL url;

    /**
     * utcOffset contains the number of minutes this place’s current timezone is offset from UTC.
     */
    public int utcOffset;

    /**
     * vicinity lists a simplified address for the place, including the street name, street number,
     * and locality, but not the province/state, postal code, or country.
     */
    public String vicinity;

    /**
     * website lists the authoritative website for this place, such as a business' homepage.
     */
    public URL website;

    /**
     * htmlAttributions contains an array of attributions about this listing which must be displayed
     * to the user.
     */
    public String[] htmlAttributions;







    public enum PriceLevel {
        FREE("0"), INEXPENSIVE("1"), MODERATE("2"), EXPENSIVE("3"), VERY_EXPENSIVE("4"),

        /**
         * Indicates an unknown price level type returned by the server. The Java Client for Google Maps
         * Services should be updated to support the new value.
         */
        UNKNOWN("Unknown");

        private final String priceLevel;

        PriceLevel(final String priceLevel) {
            this.priceLevel = priceLevel;
        }

        @Override
        public String toString() {
            return priceLevel;
        }

        public String toUrlValue() {
            if (this == UNKNOWN) {
                throw new UnsupportedOperationException("Shouldn't use PriceLevel.UNKNOWN in a request.");
            }
            return priceLevel;
        }
    }

    public enum DayOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY,

        /**
         * Indicates an unknown day of week type returned by the server. The Java Client for Google
         * Maps Services should be updated to support the new value.
         */
        UNKNOWN
    }

    public enum PlaceIdScope {
        /**
         * APP indicates the place ID is recognised by your application only.  This is because your
         * application added the place, and the place has not yet passed the moderation processExcelTemplate.
         */
        APP,
        /**
         * GOOGLE indicates the place ID is available to other applications and on Google Maps.
         */
        GOOGLE
    }
}
