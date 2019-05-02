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

import java.util.List;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimulationResults {

    protected String id;
    protected String buildingId;

    protected List<EnergyUseCalculation> monthlyCost;
    protected List<EnergyUseCalculation> monthlyConsumption;
    protected List<EnergyUseCalculation> monthlyEmissions;

    protected List<EnergyUseCalculation> monthlyCostReduction;
    protected List<EnergyUseCalculation> monthlyConsumptionReduction;
    protected List<EnergyUseCalculation> monthlyEmissionsReduction;

    protected EnergyUseCalculation annualCost;
    protected EnergyUseCalculation annualConsumption;
    protected EnergyUseCalculation annualEmissions;

    protected EnergyUseCalculation annualCostReduction;
    protected EnergyUseCalculation annualConsumptionReduction;
    protected EnergyUseCalculation annualEmissionsReduction;
}
