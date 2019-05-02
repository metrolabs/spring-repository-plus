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

package com.pivotenergy.domain.measurable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pivotenergy.domain.MultiTenantBaseEntity;
import com.pivotenergy.domain.SecurityAuditorAware;
import com.pivotenergy.domain.common.ImperialUnits;
import lombok.NoArgsConstructor;

import javax.measure.converter.UnitConverter;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;
import javax.persistence.*;
import java.util.*;

@SuppressWarnings("unused")
@Entity
@NoArgsConstructor
@EntityListeners(SecurityAuditorAware.class)
public class Measurable extends MultiTenantBaseEntity<Measurable> {

    @Column(name = "building_id", nullable = false, length = 128)
    private String buildingId;

    @Enumerated(EnumType.STRING)
    @Column(name = "`type`", nullable = false, length = 128)
    private TYPES type;

    @Enumerated(EnumType.STRING)
    @Column(name = "units", nullable = false, length = 128)
    private UNITS units;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false, length = 128)
    private CURRENCY currency;

    @Column(name = "`name`", nullable = false, length = 128)
    private String name;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "increments", nullable = false, length = 128)
    private INCREMENTS increments;

    @Basic
    @Column(name = "is_metered")
    private Boolean metered;

    @Basic
    @Column(name = "in_use")
    private Boolean inUse;

    @Basic
    @Column(name = "average_price")
    private Double averagePrice;

    @Basic
    @Column(name = "annual_emissions_kg")
    private Double annualEmissions;

    @Basic
    @Column(name = "emissions_ratio", nullable = false)
    private Double emissionsRatio;

    @Basic
    @Column(name = "annual_consumption_kwh")
    private Double annualConsumption;

    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "measurable")
    @OrderBy(value = "id DESC")
    @JsonIgnore
    private List<MeasurementHourly> hourly;

    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "measurable")
    @OrderBy(value = "id DESC")
    @JsonIgnore
    private List<MeasurementDaily> daily;

    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "measurable")
    @OrderBy(value = "id DESC")
    private List<MeasurementMonthly> monthly;

    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "measurable")
    @OrderBy(value = "id DESC")
    private List<MeasurementYearly> yearly;

    public Measurable(String buildingId, TYPES type, UNITS units, CURRENCY currency, String name,
                      INCREMENTS increments, Boolean metered, Boolean inUse, Double averagePrice,
                      Double annualEmissions, Double emissionsRatio, Double annualConsumption) {

        this.buildingId = buildingId;
        this.type = type;
        this.units = units;
        this.currency = currency;
        this.name = name;
        this.increments = increments;
        this.metered = metered;
        this.inUse = inUse;
        this.averagePrice = averagePrice;
        this.annualEmissions = annualEmissions;
        this.emissionsRatio = emissionsRatio;
        this.annualConsumption = annualConsumption;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public Measurable setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public TYPES getType() {
        return type;
    }

    public Measurable setType(TYPES type) {
        this.type = type;
        return this;
    }

    public UNITS getUnits() {
        return units;
    }

    public Measurable setUnits(UNITS units) {
        this.units = units;
        return this;
    }

    public CURRENCY getCurrency() {
        return currency;
    }

    public Measurable setCurrency(CURRENCY currency) {
        this.currency = currency;
        return this;
    }

    public String getName() {
        return name;
    }

    public Measurable setName(String name) {
        this.name = name;
        return this;
    }

    public INCREMENTS getIncrements() {
        return increments;
    }

    public Measurable setIncrements(INCREMENTS increments) {
        this.increments = increments;
        return this;
    }

    public Boolean getMetered() {
        return metered;
    }

    public Measurable setMetered(Boolean metered) {
        this.metered = metered;
        return this;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public Measurable setInUse(Boolean inUse) {
        this.inUse = inUse;
        return this;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public Measurable setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
        return this;
    }

    public Double getAnnualEmissions() {
        return annualEmissions;
    }

    public Measurable setAnnualEmissions(Double annualEmissions) {
        this.annualEmissions = annualEmissions;
        return this;
    }

    public Double getEmissionsRatio() {
        return emissionsRatio;
    }

    public Measurable setEmissionsRatio(Double emissionsRatio) {
        this.emissionsRatio = emissionsRatio;
        return this;
    }

    public Double getAnnualConsumption() {
        return annualConsumption;
    }

    public Measurable setAnnualConsumption(Double annualConsumption) {
        this.annualConsumption = annualConsumption;
        return this;
    }

    public List<MeasurementHourly> getHourly() {
        return hourly;
    }

    public Measurable setHourly(List<MeasurementHourly> hourly) {
        this.hourly = hourly;
        return this;
    }

    public List<MeasurementDaily> getDaily() {
        return daily;
    }

    public Measurable setDaily(List<MeasurementDaily> daily) {
        this.daily = daily;
        return this;
    }

    public List<MeasurementMonthly> getMonthly() {
        return monthly;
    }

    public Measurable setMonthly(List<MeasurementMonthly> monthly) {
        this.monthly = monthly;
        return this;
    }

    public List<MeasurementYearly> getYearly() {
        return yearly;
    }

    public Measurable setYearly(List<MeasurementYearly> yearly) {
        this.yearly = yearly;
        return this;
    }

    public enum TYPES {
        ELECTRIC ("Grid Electric", Constants.getElectricity(), 0d),
        NATURAL_GAS ("Natural Gas", Constants.getNaturalGas(), 0.015550350984812),
        FUEL_OIL_1 ("Fuel Oil No 1", Constants.getFuel(), 0.02146745589215),
        FUEL_OIL_2 ("Fuel Oil No 2", Constants.getFuel(), 0.021675536351992),
        FUEL_OIL_4 ("Fuel Oil No 4", Constants.getFuel(), 0.021992053107808),
        FUEL_OIL_5_6 ("Fuel Oil No 5 or 6", Constants.getFuel(), 0.02200963737202),
        DISTRICT_STEAM ("District Steam", Constants.getDistrictSteam(), 0d),
        DISTRICT_HOT_WATER ("District Hot Water", Constants.getDistrictHotWater(), 0d),
        DISTRICT_CHILLED_WATER ("District Chilled Water", Constants.getDistrictChilledWater(), 0d),
        PROPANE ("Propane", Constants.getPropane(), 0.018012147974492),
        KEROSENE ("Kerosene", Constants.getFuel(), 0.02203894447904),
        DIESEL ("Diesel", Constants.getFuel(), 0.020579450549444),
        COAL_ANTHRACITE ("Coal Anthracite", Constants.getCarbonaceous(), 0.030388539269038),
        COAL_BITUMINOUS ("Coal Bituminous", Constants.getCarbonaceous(), 0.027337669428256),
        COKE ("Coke", Constants.getCarbonaceous(), 0.033313388549634),
        WOOD ("Wood", Constants.getWood(), 0.02749006638476);

        private String description;
        private Map<String, Constants.Meta> baseUnit;
        private double ghgFactor;

        TYPES(String description, Map<String, Constants.Meta> unit, double ghgFactor) {
            this.description = description;
            this.baseUnit = unit;
            this.ghgFactor = ghgFactor;
        }

        public String getDescription() {
            return description;
        }

        public Map<String, Constants.Meta> getTypeUnits() {
            return baseUnit;
        }

        public Set<String> getTypeUnitKeys() {
            return baseUnit.keySet();
        }

        public double getGhgFactor() {
            return ghgFactor;
        }
    }

    public enum UNITS {
        J       (Constants.J),
        GJ      (Constants.GJ),
        MJ      (Constants.MJ),
        KJ      (Constants.KJ),
        CM      (Constants.CM),
        CF      (Constants.CF),
        CCF     (Constants.CCF),
        MCF     (Constants.MCF),
        KWH     (Constants.KWH),
        MWH     (Constants.MWH),
        GWH     (Constants.GWH),
        KBTU    (Constants.KBTU),
        MBTU    (Constants.MBTU),
        LBS     (Constants.LBS),
        KLBS    (Constants.KLBS),
        MLBS    (Constants.MLBS),
        TONNE   (Constants.TONS),
        GALLON  (Constants.GALLONS),
        LITERS  (Constants.LITERS),
        THERMS  (Constants.THERMS),
        TON_HRS (Constants.TON_HRS);

        private Constants.Meta unit;

        UNITS(Constants.Meta unit) {
            this.unit = unit;
        }

        public Constants.Meta getUnitMeta() {
            return unit;
        }
    }

    public enum CURRENCY {
        HRK,
        CHF,
        ALL,
        MXN,
        GTQ,
        CLP,
        HNL,
        ZAR,
        TND,
        VND,
        AUD,
        ILS,
        BOB,
        IDR,
        SDG,
        TRY,
        LBP,
        IQD,
        JOD,
        CUP,
        AED,
        TWD,
        HKD,
        RSD,
        EUR,
        DOP,
        DKK,
        MYR,
        CAD,
        BGN,
        SYP,
        NOK,
        RON,
        UYU,
        MAD,
        CZK,
        OMR,
        CRC,
        SEK,
        UAH,
        BHD,
        SVC,
        ARS,
        QAR,
        SAR,
        YER,
        INR,
        THB,
        CNY,
        KRW,
        JPY,
        PLN,
        GBP,
        CSD,
        LYD,
        HUF,
        PHP,
        KWD,
        BYR,
        RUB,
        PYG,
        ISK,
        COP,
        USD,
        MKD,
        BAM,
        EGP,
        DZD,
        PAB,
        SGD,
        NIO,
        VEF,
        PEN,
        NZD,
        BRL
    }

    public enum INCREMENTS {
        MINUTE,
        HOUR,
        DAY,
        MONTH
    }

    @SuppressWarnings("WeakerAccess")
    public static class Constants {
        @SuppressWarnings("WeakerAccess")
        public static class Meta {
            private String name;
            private Unit<?> baseUnit;
            private Unit<?> fromUnit;

            public Meta(String name, Unit<?> baseUnit, Unit<?> fromUnit) {
                this.name = name;
                this.baseUnit = baseUnit;
                this.fromUnit = fromUnit;
            }

            public String getName() {
                return name;
            }

            public Unit<?> getBaseUnit() {
                return baseUnit;
            }

            public Unit<?> getFromUnit() {
                return fromUnit;
            }

            public double toBase(Number val) {
                UnitConverter converter = fromUnit.getConverterTo(baseUnit);
                return converter.convert(val.doubleValue());
            }

            public double fromBase(Number val) {
                UnitConverter converter = baseUnit.getConverterTo(fromUnit);
                return converter.convert(val.doubleValue());
            }
        }

        private static  Unit<?> _KWH = SI.KILO(SI.WATT).times(NonSI.HOUR);
        private static Map<String, Meta> UNITS = new HashMap<>();
        static {
            UNITS.put("GJ",         new Constants.Meta("GJ",      _KWH, SI.GIGA(SI.JOULE)));
            UNITS.put("MJ",         new Constants.Meta("MJ",      _KWH, SI.MEGA(SI.JOULE)));
            UNITS.put("KJ",         new Constants.Meta("KJ",      _KWH, SI.KILO(SI.JOULE)));
            UNITS.put("J",          new Constants.Meta("J",       _KWH, SI.JOULE));
            UNITS.put("KBTU",       new Constants.Meta("KBTU",    _KWH, SI.KILO(ImperialUnits.BTU_NG)));
            UNITS.put("MBTU",       new Constants.Meta("MBTU",    _KWH, SI.MEGA(ImperialUnits.BTU_NG)));
            UNITS.put("KWH",        new Constants.Meta("KWH",     _KWH, SI.KILO(SI.WATT).times(NonSI.HOUR)));
            UNITS.put("MWH",        new Constants.Meta("MWH",     _KWH, SI.MEGA(SI.WATT).times(NonSI.HOUR)));
            UNITS.put("GWH",        new Constants.Meta("GWH",     _KWH, SI.GIGA(SI.WATT).times(NonSI.HOUR)));
            UNITS.put("CF",         new Constants.Meta("CF",      _KWH, ImperialUnits.CUBIC_FEET_NG));
            UNITS.put("CCF",        new Constants.Meta("CCF",     _KWH, SI.CENTI(ImperialUnits.CUBIC_FEET_NG)));
            UNITS.put("KCF",        new Constants.Meta("KCF",     _KWH, SI.KILO(ImperialUnits.CUBIC_FEET_NG)));
            UNITS.put("MCF",        new Constants.Meta("MCF",     _KWH, SI.MEGA(ImperialUnits.CUBIC_FEET_NG)));
            UNITS.put("THERMS",     new Constants.Meta("THERMS",  _KWH, ImperialUnits.THERM_NG));
            UNITS.put("CM",         new Constants.Meta("CM",      _KWH, ImperialUnits.CUBIC_METRE_NG));
            UNITS.put("GALLONS",    new Constants.Meta("GALLONS", _KWH, NonSI.GALLON_LIQUID_US));
            UNITS.put("LITERS",     new Constants.Meta("LITERS",  _KWH, NonSI.LITER));
            UNITS.put("LBS",        new Constants.Meta("LBS",     _KWH, NonSI.POUND));
            UNITS.put("KLBS",       new Constants.Meta("KLBS",    _KWH, SI.KILO(NonSI.POUND)));
            UNITS.put("MLBS",       new Constants.Meta("MLBS",    _KWH, SI.MEGA(NonSI.POUND)));
            UNITS.put("TON_HRS",    new Constants.Meta("TON_HRS", _KWH, NonSI.TON_US.times(NonSI.HOUR)));
            UNITS.put("TONS",       new Constants.Meta("TONS",    _KWH, NonSI.TON_US));
        }

        public static final Constants.Meta GJ      = UNITS.get("GJ");
        public static final Constants.Meta MJ      = UNITS.get("MJ");
        public static final Constants.Meta KJ      = UNITS.get("KJ");
        public static final Constants.Meta J       = UNITS.get("J");
        public static final Constants.Meta KBTU    = UNITS.get("KBTU");
        public static final Constants.Meta MBTU    = UNITS.get("MBTU");
        public static final Constants.Meta KWH     = UNITS.get("KWH");
        public static final Constants.Meta MWH     = UNITS.get("MWH");
        public static final Constants.Meta GWH     = UNITS.get("GWH");
        public static final Constants.Meta CF      = UNITS.get("CF");
        public static final Constants.Meta CCF     = UNITS.get("CCF");
        public static final Constants.Meta KCF     = UNITS.get("KCF");
        public static final Constants.Meta MCF     = UNITS.get("MCF");
        public static final Constants.Meta THERMS  = UNITS.get("THERMS");
        public static final Constants.Meta CM      = UNITS.get("CM");
        public static final Constants.Meta GALLONS = UNITS.get("GALLONS");
        public static final Constants.Meta LITERS  = UNITS.get("LITERS");
        public static final Constants.Meta LBS     = UNITS.get("LBS");
        public static final Constants.Meta KLBS    = UNITS.get("KLBS");
        public static final Constants.Meta MLBS    = UNITS.get("MLBS");
        public static final Constants.Meta TON_HRS = UNITS.get("TON_HRS");
        public static final Constants.Meta TONS    = UNITS.get("TONS");

        public static Map getUnits() {
            return UNITS;
        }

        public static Constants.Meta getUnit(String unit) {
            return UNITS.get(unit);
        }

        public static Map getElectricity() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(GWH.getName(), GWH);
            UNITS.put(MWH.getName(), MWH);
            UNITS.put(KWH.getName(), KWH);

            return UNITS;
        }

        public static Map getNaturalGas() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(THERMS.getName(), THERMS);
            UNITS.put(MBTU.getName(),   MBTU);
            UNITS.put(KBTU.getName(),   KBTU);
            UNITS.put(MCF.getName(),    MCF);
            UNITS.put(KCF.getName(),    KCF);
            UNITS.put(CCF.getName(),    CCF);
            UNITS.put(CF.getName(),     CF);
            UNITS.put(CM.getName(),     CM);

            return UNITS;
        }

        public static Map getPropane() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(GALLONS.getName(),    GALLONS);
            UNITS.put(LITERS.getName(),     LITERS);
            UNITS.put(MBTU.getName(),       MBTU);
            UNITS.put(KBTU.getName(),       KBTU);
            UNITS.put(KCF.getName(),        KCF);
            UNITS.put(CF.getName(),         CF);

            return UNITS;
        }

        public static Map getDistrictSteam() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(THERMS.getName(), THERMS);
            UNITS.put(MBTU.getName(),   MBTU);
            UNITS.put(KBTU.getName(),   KBTU);
            UNITS.put(LBS.getName(),    LBS);
            UNITS.put(KLBS.getName(),   KLBS);
            UNITS.put(MLBS.getName(),   MLBS);

            return UNITS;
        }

        public static Map getDistrictHotWater() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(MBTU.getName(),       MBTU);
            UNITS.put(KBTU.getName(),       KBTU);
            UNITS.put(THERMS.getName(),     THERMS);
            UNITS.put(TON_HRS.getName(),    TON_HRS);

            return UNITS;
        }

        public static Map getDistrictChilledWater() {
            return getDistrictHotWater();
        }

        public static Map getFuel() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(MBTU.getName(),       MBTU);
            UNITS.put(KBTU.getName(),       KBTU);
            UNITS.put(GALLONS.getName(),    GALLONS);
            UNITS.put(LITERS.getName(),     LITERS);

            return UNITS;
        }

        public static Map getCarbonaceous() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(MBTU.getName(),   MBTU);
            UNITS.put(KBTU.getName(),   KBTU);
            UNITS.put(LBS.getName(),    LBS);
            UNITS.put(KLBS.getName(),   KLBS);
            UNITS.put(MLBS.getName(),   MLBS);
            UNITS.put(TONS.getName(),   TONS);

            return UNITS;
        }

        public static Map getWood() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(MBTU.getName(),   MBTU);
            UNITS.put(KBTU.getName(),   KBTU);
            UNITS.put(TONS.getName(),   TONS);

            return UNITS;
        }

        public static Map getWater() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(GALLONS.getName(),    GALLONS);
            UNITS.put(LITERS.getName(),     LITERS);

            return UNITS;
        }

        public static Map getOther() {
            Map<String, Meta> UNITS = new HashMap<>();
            UNITS.put(KBTU.getName(),   KBTU);

            return UNITS;
        }
    }

    @SuppressWarnings("WeakerAccess")
    public static class META {
        private String key;
        private String description;
        private Collection<String> unitsOfMeasure;

        public META() {}

        public META(String key) {
            TYPES type = TYPES.valueOf(key);

            this.key            = type.name();
            this.description    = type.getDescription();
            this.unitsOfMeasure = type.getTypeUnits().keySet();
        }

        public META(TYPES type) {
            this.key            = type.name();
            this.description    = type.getDescription();
            this.unitsOfMeasure = type.getTypeUnits().keySet();
        }

        public META(String key, String description, Collection<String> unitsOfMeasure) {
            this.key            = key;
            this.description    = description;
            this.unitsOfMeasure = unitsOfMeasure;
        }

        public String getKey() {
            return key;
        }

        public String getDescription() {
            return description;
        }

        public Collection<String> getUnitsOfMeasure() {
            return unitsOfMeasure;
        }

        public static Map<String, META> getMeterTypes() {
            Map<String, META> collection = new TreeMap<>();
            for(TYPES type : TYPES.values()) {
                collection.put(type.name(), new META(type));
            }

            return collection;
        }
    }
}
