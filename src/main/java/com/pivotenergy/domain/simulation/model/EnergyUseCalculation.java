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

package com.pivotenergy.domain.simulation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnergyUseCalculation {
    public int month;
    public String monthName;
    public double heating;
    public double cooling;
    public double internalLighting;
    public double externalLighting;
    public double fans;
    public double pumps;
    public double electricPointLoads;
    public double fossilFuelPointLoads;
    public double domesticHotWater;
    public double solarHotWater;
    public double photovoltaic;
    public double windTurbine;
    public double internalHeatGain;
    public double solarHeatGain;
    public double interiorTemperature;
    public double outsideTemperature;
    public double totalHVAC;
    public double totalLighting;
    public double totalRenewables;
    public double summedTotal;
    public int peakDemandDay;
    public int peakDemandHour;
    public double peakDemand;
    public PeakHour peakHourCalculation;
    public Map<String, ZoneCalculationReport> zoneDemand;
}
