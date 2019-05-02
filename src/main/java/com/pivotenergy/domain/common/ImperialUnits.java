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

package com.pivotenergy.domain.common;

import javax.measure.quantity.Energy;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Volume;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.SystemOfUnits;
import javax.measure.unit.Unit;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static javax.measure.unit.NonSI.*;

public class ImperialUnits extends SystemOfUnits {

    /**
     * Holds collection of ImperialUnits units.
     */
    private static HashSet<Unit<?>> UNITS = new HashSet<Unit<?>>();

    /**
     * Holds the standard gravity constant: 9.80665 m/s² exact.
     */
    private static final int STANDARD_GRAVITY_DIVIDEND = 980665;
    private static final int STANDARD_GRAVITY_DIVISOR  = 100000;

    /**
     * Holds the international foot: 0.3048 m exact.
     */
    private static final int INTERNATIONAL_FOOT_DIVIDEND =  3048;
    private static final int INTERNATIONAL_FOOT_DIVISOR  = 10000;

    /**
     * Holds the avoirdupois pound: 0.45359237 kg exact
     */
    private static final int AVOIRDUPOIS_POUND_DIVIDEND =  45359237;
    private static final int AVOIRDUPOIS_POUND_DIVISOR  = 100000000;

    /**
     *  Holds the poundal: 0.138254954376 N exact
     **/
    private static final long POUNDAL_DIVIDEND =  138254954376L;
    private static final long POUNDAL_DIVISOR  = 1000000000000L;
    /**
     * Holds the Avogadro constant.
     */
    private static final double AVOGADRO_CONSTANT = 6.02214199e23; // (1/mol).

    /**
     * Holds the electric charge of one electron.
     */
    private static final double ELEMENTARY_CHARGE = 1.602176462e-19; // (C).

    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private ImperialUnits() {
    }

    /**
     * Returns the unique instance of this class.
     *
     * @return the ImperialUnits instance.
     */
    public static ImperialUnits getInstance() {
        return INSTANCE;
    }
    private static final ImperialUnits INSTANCE = new ImperialUnits();

    //////////////
    // Velocity //
    //////////////

    //////////
    // Area //
    //////////

    ////////////
    // Energy //
    ////////////
    /**
     * The ISO 31-4 British Thermal Unit for Natural Gas is a unit of energy equal to
     * <code>1055.056 J</code> (standard name <code>BTU</code>).
     */
    public static final Unit<Energy> BTU_NG = nonSI(SI.JOULE.times(1055.056));

    /**
     * Therm (EC) ≡ 100,000 BTU ISO OR 105,505,600 joules for Natural Gas
     */
    public static final Unit<Energy> THERM_NG = nonSI(ImperialUnits.BTU_NG.times(100000));

    /**
     * A unit of volume equal to one cubic foot (<code>ft³</code>).
     */
    public static final Unit<Energy> CUBIC_FEET_NG = nonSI(ImperialUnits.BTU_NG.times(1000));

    public static final Unit<Energy> CUBIC_METRE_NG = nonSI(ImperialUnits.CUBIC_FEET_NG.times(0.028316846));

    //////////////
    // Pressure //
    //////////////
    /**
     * A unit of pressure equal to 1 lbf/in² (abbreviation <code>psi</code>).
     */
    public static final Unit<Pressure> POUNDS_PER_SQUARE_INCH = nonSI(new ProductUnit<Pressure>(
            POUND_FORCE.divide(INCH.pow(2))));

    /**
     * A unit of pressure equal to 1 lbf/ft² (abbreviation <code>psf</code>).
     */
    public static final Unit<Pressure> POUNDS_PER_SQUARE_FOOT = nonSI(new ProductUnit<Pressure>(
            POUND_FORCE.divide(FOOT.pow(2))));

    ////////////
    // Volume //
    ////////////
    /**
     * A unit of volume equal to one cubic inch (<code>in³</code>).
     */
    public static final Unit<Volume> CUBIC_INCH = nonSI(INCH.pow(3).asType(Volume.class));

    /**
     * A unit of volume equal to one cubic foot (<code>ft³</code>).
     */
    public static final Unit<Volume> CUBIC_FOOT = nonSI(FOOT.pow(3).asType(Volume.class));

    /**
     * Centum cubic feet (100 cubic feet), an American standard unit of measurement for the volume of
     * water or natural gas, sometimes capitalized as "Ccf" (from the Roman numeral for 100, C; see also Therm)
     * Example: equals the volume of 100 cubic feet (cf) of natural gas
     */
    public static final Unit<Volume> CCF = nonSI(CUBIC_FOOT.times(100));


    /////////////////////
    // Collection View //
    /////////////////////

    /**
     * Returns a read only view over the units defined in this class.
     *
     * @return the collection of ImperialUnits units.
     */
    public Set<Unit<?>> getUnits() {
        return Collections.unmodifiableSet(UNITS);
    }

    /**
     * Adds a new unit to the collection.
     *
     * @param  unit the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U nonSI(U unit) {
        UNITS.add(unit);
        return unit;
    }
}
