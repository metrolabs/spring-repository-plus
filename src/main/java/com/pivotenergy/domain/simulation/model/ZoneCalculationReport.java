package com.pivotenergy.domain.simulation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZoneCalculationReport {
    protected String id;
    protected String zoneName;
    protected String zoneType;
    protected int month;
    protected String monthName;
    protected double conditionedFloorArea = 0d;
    protected double conditionedFloorAreaFraction = 0d;
    protected double zoneOccupancy = 0d;
    protected double zoneOccupancyFraction = 0d;
    protected double domesticHotWaterDemand = 0d;
    protected double domesticHotWaterDemandFraction = 0d;
    protected double gasApplianceDemand = 0d;
    protected double gasApplianceDemandFraction = 0d;
    protected double electricApplianceDemand = 0d;
    protected double electricApplianceDemandFraction = 0d;
    protected double interiorLightingDemand = 0d;
    protected double interiorLightingDemandFraction = 0d;
    protected double heatingDemand = 0d;
    protected double heatingDemandFraction = 0d;
    protected double coolingDemand = 0d;
    protected double coolingDemandFraction = 0d;
    protected double fansDemand = 0d;
    protected double fansDemandFraction = 0d;
    protected double pumpsDemand = 0d;
    protected double pumpsDemandFraction = 0d;
}
