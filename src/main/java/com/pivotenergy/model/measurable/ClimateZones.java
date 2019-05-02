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

import java.util.HashMap;
import java.util.Map;

public enum ClimateZones {
    A	("A", "Tropical Climate"),
    AF	("AF", "Tropical Wet Climate"),
    AM	("AM", "Tropical Monsoon Climate"),
    AS	("AS", "Tropical Dry Summer"),
    AW	("AW", "Tropical Dry Winter"),
    B	("B", "Dry Arid Climate - Deserts"),
    BSH	("BSH", "Dry Semi-Arid Hot"),
    BSK	("BSK", "Dry Semi-Arid Cold"),
    BWH	("BWH", "Dry Arid Hot"),
    BWK	("BWK", "Dry Arid Cold"),
    C	("C", "Moderately Hot Climate"),
    CFA	("CFA", "Moderately Hot - Wet Climate With Hot Summers"),
    CFB	("CFB", "Moderately Hot - Wet Climate With Moderate Summers"),
    CFC	("CFC", "Moderately Hot - Wet Climate With Short & Cold Summers"),
    CSA	("CSA", "Moderately Hot - Dry & Hot Summers"),
    CSB	("CSB", "Moderately Hot - Dry & Moderate Summers"),
    CSC	("CSC", "Moderately Hot - Dry, Short & Cold Summers"),
    CWA	("CWA", "Moderately Hot - Dry Winters & Hot Summers"),
    CWB	("CWB", "Moderately Hot - Dry Winters & Moderate Summers"),
    CWC	("CWC", "Moderately Hot - Dry Winters & Short, Cold Summers"),
    D	("D", "Moderately Cold"),
    DFA	("DFA", "Moderately Cold - Wet Climate With Hot Summers"),
    DFB	("DFB", "Moderately Cold - Wet Climate With Moderate Summers"),
    DFC	("DFC", "Moderately Cold - Wet Climate With Short & Cold Summers"),
    DFD	("DFD", "Moderately Cold - Wet Climate With Very Cold Winters"),
    DSA	("DSA", "Moderately Cold - Dry & Hot Summers"),
    DSB	("DSB", "Moderately Cold - Dry & Moderate Summers"),
    DSC	("DSC", "Moderately Cold - Dry, Short & Cold Summers"),
    DWA	("DWA", "Moderately Cold - Dry Winters With Hot Summers"),
    DWB	("DWB", "Moderately Cold - Dry Winters With Moderate Summers"),
    DWC	("DWC", "Moderately Cold - Dry Winters With Short & Cold Summers"),
    DWD	("WD", "Moderately Cold - Dry Winters With Very Cold Winters"),
    E	("E", "Polar climate"),
    EF	("EF", "Polar Ice Covered"),
    EM	("EM", "Polar Maritime climate"),
    ET	("ET", "Polar Tundra - Wet Climate");

    private String key;
    private String name;
    private static final Map<String, ClimateZones> lookupKeys = new HashMap<>();
    static {
        for (ClimateZones p : ClimateZones.values()){
            lookupKeys.put(p.getKey(), p);
        }
    }

    ClimateZones(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public static ClimateZones key(String key) {
        return lookupKeys.get(key);
    }
}
