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

package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@NoArgsConstructor
public class SummaryAnnual {

    @Embedded
    private HVAC hvac;

    @Embedded
    private Lighting lighting;

    @Embedded
    private PlugLoad plugLoad;

    @Embedded
    private Renewable renewable;

    @Column(name = "total", nullable = false)
    private Double total;

    public SummaryAnnual(HVAC hvac_, Lighting lighting_, PlugLoad plugLoad_, Renewable renewable_) {
        this.hvac = hvac_;
        this.lighting = lighting_;
        this.plugLoad = plugLoad_;
        this.renewable = renewable_;
        this.total = (hvac.getTotal() + lighting.getTotal() + plugLoad.getTotal()) - renewable.getTotal();
    }

    public HVAC getHvac() {
        return hvac;
    }

    public Lighting getLighting() {
        return lighting;
    }

    public PlugLoad getPlugLoad() {
        return plugLoad;
    }

    public Renewable getRenewable() {
        return renewable;
    }

    public Double getTotal() {
        return total;
    }
}
