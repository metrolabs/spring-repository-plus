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

@Getter
@Setter
@NoArgsConstructor
public class AlternatePlaceIds {
    /**
     * placeId — The most likely reason for a place to have an alternative place ID is if your
     * application adds a place and receives an application-scoped place ID, then later receives a
     * Google-scoped place ID after passing the moderation processExcelTemplate.
     */
    public String placeId;

    /**
     * scope — The scope of an alternative place ID will always be APP, indicating that the
     * alternative place ID is recognised by your application only.
     */
    public LocationDetails.PlaceIdScope scope;
}
