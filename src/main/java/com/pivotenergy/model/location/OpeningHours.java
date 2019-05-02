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
public class OpeningHours {
    /**
     * openNow is a boolean value indicating if the place is open at the current time.
     *
     * <p>Note: this field will be null if it isn't present in the response.</p>
     */
    public Boolean openNow;

    /**
     * periods is an array of opening periods covering seven days, starting from Sunday, in
     * chronological order.
     */
    public Period[] periods;

    /**
     * weekdayText is an array of seven strings representing the formatted opening hours for each day
     * of the week, for example "Monday: 8:30 am – 5:30 pm".
     */
    public String[] weekdayText;

    /**
     * permanentlyClosed indicates that the place has permanently shut down.
     *
     * <p>Note: this field will be null if it isn't present in the response.</p>
     */
    public Boolean permanentlyClosed;
}
