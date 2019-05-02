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

package com.pivotenergy.model.measurable;

import com.pivotenergy.domain.measurable.ClimateDataHourly;

public class DegreeDay {

    private String id;
    private String stationId;
    private int year;
    private int month;
    private int day;

    private double heatingBalancePointCelsius;
    private double coolingBalancePointCelsius;
    private int hddCelsius;
    private int cddCelsius;

    private double heatingBalancePointFahrenheit;
    private double coolingBalancePointFahrenheit;
    private int hddFahrenheit;
    private int cddFahrenheit;

    public DegreeDay(){}

    public DegreeDay(String id, String stationId, int year, int month, int day,
                     double heatingBalancePointCelsius, double coolingBalancePointCelsius,
                     double heatingBalancePointFahrenheit, double coolingBalancePointFahrenheit)
    {
        this.id = id;
        this.stationId = stationId;
        this.year = year;
        this.month = month;
        this.day = day;
        this.heatingBalancePointCelsius = heatingBalancePointCelsius;
        this.coolingBalancePointCelsius = coolingBalancePointCelsius;
        this.hddCelsius = 0;
        this.cddCelsius = 0;
        this.heatingBalancePointFahrenheit = heatingBalancePointFahrenheit;
        this.coolingBalancePointFahrenheit = coolingBalancePointFahrenheit;
        this.hddFahrenheit = 0;
        this.cddFahrenheit = 0;
    }

    public String getId() {
        return id;
    }

    public DegreeDay setId(String id) {
        this.id = id;
        return this;
    }

    public String getStationId() {
        return stationId;
    }

    public DegreeDay setStationId(String stationId) {
        this.stationId = stationId;
        return this;
    }

    public int getYear() {
        return year;
    }

    public DegreeDay setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public DegreeDay setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public DegreeDay setDay(int day) {
        this.day = day;
        return this;
    }

    public double getHeatingBalancePointCelsius() {
        return heatingBalancePointCelsius;
    }

    public DegreeDay setHeatingBalancePointCelsius(double heatingBalancePointCelsius) {
        this.heatingBalancePointCelsius = heatingBalancePointCelsius;
        return this;
    }

    public double getCoolingBalancePointCelsius() {
        return coolingBalancePointCelsius;
    }

    public DegreeDay setCoolingBalancePointCelsius(double coolingBalancePointCelsius) {
        this.coolingBalancePointCelsius = coolingBalancePointCelsius;
        return this;
    }

    public int getHddCelsius() {
        return hddCelsius;
    }

    public DegreeDay setHddCelsius(int hddCelsius) {
        this.hddCelsius = hddCelsius;
        return this;
    }

    public int getCddCelsius() {
        return cddCelsius;
    }

    public DegreeDay setCddCelsius(int cddCelsius) {
        this.cddCelsius = cddCelsius;
        return this;
    }

    public double getHeatingBalancePointFahrenheit() {
        return heatingBalancePointFahrenheit;
    }

    public DegreeDay setHeatingBalancePointFahrenheit(double heatingBalancePointFahrenheit) {
        this.heatingBalancePointFahrenheit = heatingBalancePointFahrenheit;
        return this;
    }

    public double getCoolingBalancePointFahrenheit() {
        return coolingBalancePointFahrenheit;
    }

    public DegreeDay setCoolingBalancePointFahrenheit(double coolingBalancePointFahrenheit) {
        this.coolingBalancePointFahrenheit = coolingBalancePointFahrenheit;
        return this;
    }

    public int getHddFahrenheit() {
        return hddFahrenheit;
    }

    public DegreeDay setHddFahrenheit(int hddFahrenheit) {
        this.hddFahrenheit = hddFahrenheit;
        return this;
    }

    public int getCddFahrenheit() {
        return cddFahrenheit;
    }

    public DegreeDay setCddFahrenheit(int cddFahrenheit) {
        this.cddFahrenheit = cddFahrenheit;
        return this;
    }

    public void sum(ClimateDataHourly c) {
        hddCelsius    += calcHdd(c.getAirTempCelsius(), heatingBalancePointCelsius);
        cddCelsius    += calcCdd(c.getAirTempCelsius(), coolingBalancePointCelsius);
        hddFahrenheit += calcHdd(c.getAirTempFahrenheit(), heatingBalancePointFahrenheit);
        cddFahrenheit += calcCdd(c.getAirTempFahrenheit(), coolingBalancePointFahrenheit);
    }

    public int calcHdd(double avgTemp, double bp) {
        return (int)(avgTemp < bp ? (bp - avgTemp) : 0);
    }

    public int calcCdd(double avgTemp, double bp) {
        return (int)(avgTemp > bp ? (avgTemp - bp) : 0);
    }
}
