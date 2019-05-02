package com.pivotenergy.domain.simulation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeakHour implements Serializable {
    protected int month;
    protected String monthName;
    /**
     * Consumed/Generated Energy - Watts per Hour (W/hr)
     */
    protected double heating           = 0d;
    protected double cooling           = 0d;
    protected double lightingInternal  = 0d;
    protected double lightingExternal  = 0d;
    protected double fans              = 0d;
    protected double pumps             = 0d;
    protected double electricPointLoad = 0d;
    protected double naturalGasPointLoad = 0d;
    protected double domesticHotWater  = 0d;
    protected double eGenPhotovoltaic  = 0d;
    protected double eGenWind          = 0d;
    protected double eGenSolarHotWater = 0d;
    protected double total             = 0d;

    /**
     * Energy Use By Energy Type
     */
    protected double districtHeating   = 0d;
    protected double districtCooling   = 0d;
    protected double districtSteam     = 0d;
    protected double electricity       = 0d;
    protected double gaseous           = 0d;
    protected double stream            = 0d;
    protected double fuel              = 0d;

    /**
     * Hourly Thermal Energy Need
     * TairAc:      Tair,ac...          (=CALC_H!FR35)[C48]
     * Qtr:         Qtr [kWh/m2]        (=CALC_H!Z35) [D48]
     * Qve:         Qve [kWh/m2]        (=CALC_H!Y35) [E48]
     * Qht:         Qht [kWh/m2]        (=D48+E48)    [F48]
     * Qsol:        Qsol [kWh/m2]       (=CALC_H!T35) [G48]
     * QintOccApp:  Qint,oc+ap [kWh/m2] (=CALC_H!U35) [H48]
     * QintLi:      Qint,li [kWh/m2]    (=CALC_H!V35) [I48]
     * Qgn:         Qgn [kWh/m2]        (=CALC_H!W35) [J48]
     * QHnd:        QH,nd [kWh/m2]      (=CALC_H!AZ35)[K48]
     * QCnd:        QC,nd [kWh/m2]      (=CALC_H!BA35)[L48]
     */
    protected double TairAc        = 0d;
    protected double Qtr           = 0d;
    protected double Qve           = 0d;
    protected double Qht           = 0d;
    protected double Qsol          = 0d;
    protected double QintOccApp    = 0d;
    protected double QintLi        = 0d;
    protected double Qgn           = 0d;
    protected double QHnd          = 0d;
    protected double QCnd          = 0d;

    protected double outsideTemperature;
    protected double interiorTemperature;
    protected double floatingTemperature;
    protected double internalHeatGain;
    protected double solarHeatGain;

    protected double heatingSetPoint;
    protected double coolingSetPoint;

    protected int peakDay;
    protected int peakHour;
    protected double peakDemand;
}
