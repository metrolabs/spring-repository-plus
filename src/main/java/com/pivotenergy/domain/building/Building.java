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

package com.pivotenergy.domain.building;

import com.pivotenergy.domain.MultiTenantBaseEntity;
import com.pivotenergy.domain.SecurityAuditorAware;
import com.pivotenergy.model.location.LocationAddress;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.Set;

@SuppressWarnings("unused")
@Entity
@NoArgsConstructor
@EntityListeners(SecurityAuditorAware.class)
public class Building extends MultiTenantBaseEntity<Building> {

    @NotBlank
    @Column(name = "building_name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "pri_address", nullable = false)
    private String address;

    @Column(name = "sub_address")
    private String address2;

    @NotBlank
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "country", nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private Country country;

    @NotBlank
    @Column(name = "state_provence", nullable = false)
    private String stateProvence;

    @Column(name = "postal", length = 20)
    private String postal;

    @NotNull
    @Range(max = 90)
    @Column(name = "latitude", precision = 8)
    private Double latitude;

    @NotNull
    @Range(max = 180)
    @Column(name = "longitude", precision = 8)
    private Double longitude;

    @Column(name = "koppen")
    private String koppen;

    @Column(name = "noaa_station_id")
    private String noaaStationId;

    @Column(name = "epw_data_id")
    private String epwDataId;

    @Past
    @NotNull
    @Column(name = "year_built", nullable = false)
    private Integer yearBuilt;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "primary_function", nullable = false)
    private PrimaryBuildingType buildingType;

    @NotNull
    @Min(value = 0)
    @Column(name = "gross_floor_area_m2", nullable = false)
    private Integer grossFloorAreaM2;

    @NotNull
    @Min(value = 0)
    @Column(name = "gross_floor_area_ft2", nullable = false)
    private Integer grossFloorAreaFt2;

    @NotNull
    @Min(value = 0)
    @Column(name = "gross_floor_area", nullable = false)
    private Integer grossFloorArea;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gross_floor_area_unit", nullable = false)
    private GrossFloorAreaUnitsType grossFloorAreaUnit;

    @Column(name = "energy_consumption_intensity")
    private Double energyConsumptionIntensity;

    @Column(name = "energy_cost_intensity")
    private Double energyCostIntensity;

    @Column(name = "emissions_intensity")
    private Double emissionsIntensity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_measurement_date")
    private Date lastMeasurementDate;

    @Column(name = "plug_load_model_data_accepted", nullable = false)
    private Boolean plugLoadModelDataAccepted = false;

    @Column(name = "domestic_hot_water_model_data_accepted", nullable = false)
    private Boolean domesticHotWaterModelDataAccepted = false;

    @Column(name = "hvac_heating_system_model_data_accepted", nullable = false)
    private Boolean hvacHeatingSystemModelDataAccepted = false;

    @Column(name = "hvac_distribution_system_model_data_accepted", nullable = false)
    private Boolean hvacDistributionSystemModelDataAccepted = false;

    @Column(name = "hvac_cooling_system_model_data_accepted", nullable = false)
    private Boolean hvacCoolingSystemModelDataAccepted = false;

    @Column(name = "envelope_model_data_accepted", nullable = false)
    private Boolean envelopeModelDataAccepted = false;

    @Column(name = "renewable_energy_model_data_accepted", nullable = false)
    private Boolean renewableEnergyModelDataAccepted = false;

    @Column(name = "lighting_system_model_data_accepted", nullable = false)
    private Boolean lightingSystemModelDataAccepted = false;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<ExternalIdentifier> identifiers;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<BuildingImage> images;

    @Column(name = "location_details", columnDefinition = "TEXT")
    @Type(type = "com.pivotenergy.model.location.LocationAddress")
    private LocationAddress locationDetails;


    public String getName() {
        return name;
    }

    public Building setName(String primaryName) {
        this.name = primaryName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Building setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public Building setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Building setCity(String city) {
        this.city = city;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Building setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getStateProvence() {
        return stateProvence;
    }

    public Building setStateProvence(String stateProvence) {
        this.stateProvence = stateProvence;
        return this;
    }

    public String getPostal() {
        return postal;
    }

    public Building setPostal(String postal) {
        this.postal = postal;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Building setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Building setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getKoppen() {
        return koppen;
    }

    public Building setKoppen(String koppen) {
        this.koppen = koppen;
        return this;
    }

    public String getNoaaStationId() {
        return noaaStationId;
    }

    public Building setNoaaStationId(String noaaStationId) {
        this.noaaStationId = noaaStationId;
        return this;
    }

    public String getEpwDataId() {
        return epwDataId;
    }

    public Building setEpwDataId(String epwDataId) {
        this.epwDataId = epwDataId;
        return this;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public Building setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
        return this;
    }

    public PrimaryBuildingType getBuildingType() {
        return buildingType;
    }

    public Building setBuildingType(PrimaryBuildingType buildingType) {
        this.buildingType = buildingType;
        return this;
    }

    public Integer getGrossFloorAreaM2() {
        return grossFloorAreaM2;
    }

    public Building setGrossFloorAreaM2(Integer grossFloorAreaM2) {
        this.grossFloorAreaM2 = grossFloorAreaM2;
        return this;
    }

    public Integer getGrossFloorAreaFt2() {
        return grossFloorAreaFt2;
    }

    public Building setGrossFloorAreaFt2(Integer grossFloorAreaFt2) {
        this.grossFloorAreaFt2 = grossFloorAreaFt2;
        return this;
    }

    public Integer getGrossFloorArea() {
        return grossFloorArea;
    }

    public Building setGrossFloorArea(Integer grossFloorArea) {
        this.grossFloorArea = grossFloorArea;
        return this;
    }

    public GrossFloorAreaUnitsType getGrossFloorAreaUnit() {
        return grossFloorAreaUnit;
    }

    public Building setGrossFloorAreaUnit(GrossFloorAreaUnitsType grossFloorAreaUnit) {
        this.grossFloorAreaUnit = grossFloorAreaUnit;
        return this;
    }

    public Double getEnergyConsumptionIntensity() {
        return energyConsumptionIntensity;
    }

    public Building setEnergyConsumptionIntensity(Double energyConsumptionIntensity) {
        this.energyConsumptionIntensity = energyConsumptionIntensity;
        return this;
    }

    public Double getEnergyCostIntensity() {
        return energyCostIntensity;
    }

    public Building setEnergyCostIntensity(Double energyCostIntensity) {
        this.energyCostIntensity = energyCostIntensity;
        return this;
    }

    public Double getEmissionsIntensity() {
        return emissionsIntensity;
    }

    public Building setEmissionsIntensity(Double emissionsIntensity) {
        this.emissionsIntensity = emissionsIntensity;
        return this;
    }

    public Date getLastMeasurementDate() {
        return lastMeasurementDate;
    }

    public Building setLastMeasurementDate(Date lastMeasurementDate) {
        this.lastMeasurementDate = lastMeasurementDate;
        return this;
    }

    public boolean isPlugLoadModelDataAccepted() {
        return plugLoadModelDataAccepted;
    }

    public void setPlugLoadModelDataAccepted(boolean plugLoadModelDataAccepted) {
        this.plugLoadModelDataAccepted = plugLoadModelDataAccepted;
    }

    public boolean isDomesticHotWaterModelDataAccepted() {
        return domesticHotWaterModelDataAccepted;
    }

    public void setDomesticHotWaterModelDataAccepted(boolean domesticHotWaterModelDataAccepted) {
        this.domesticHotWaterModelDataAccepted = domesticHotWaterModelDataAccepted;
    }

    public boolean isHvacHeatingSystemModelDataAccepted() {
        return hvacHeatingSystemModelDataAccepted;
    }

    public void setHvacHeatingSystemModelDataAccepted(boolean hvacHeatingSystemModelDataAccepted) {
        this.hvacHeatingSystemModelDataAccepted = hvacHeatingSystemModelDataAccepted;
    }

    public boolean isHvacDistributionSystemModelDataAccepted() {
        return hvacDistributionSystemModelDataAccepted;
    }

    public void setHvacDistributionSystemModelDataAccepted(boolean hvacDistributionSystemModelDataAccepted) {
        this.hvacDistributionSystemModelDataAccepted = hvacDistributionSystemModelDataAccepted;
    }

    public boolean isHvacCoolingSystemModelDataAccepted() {
        return hvacCoolingSystemModelDataAccepted;
    }

    public void setHvacCoolingSystemModelDataAccepted(boolean hvacCoolingSystemModelDataAccepted) {
        this.hvacCoolingSystemModelDataAccepted = hvacCoolingSystemModelDataAccepted;
    }

    public boolean isEnvelopeModelDataAccepted() {
        return envelopeModelDataAccepted;
    }

    public void setEnvelopeModelDataAccepted(boolean envelopeModelDataAccepted) {
        this.envelopeModelDataAccepted = envelopeModelDataAccepted;
    }

    public boolean isRenewableEnergyModelDataAccepted() {
        return renewableEnergyModelDataAccepted;
    }

    public void setRenewableEnergyModelDataAccepted(boolean renewableEnergyModelDataAccepted) {
        this.renewableEnergyModelDataAccepted = renewableEnergyModelDataAccepted;
    }

    public boolean isLightingSystemModelDataAccepted() {
        return lightingSystemModelDataAccepted;
    }

    public void setLightingSystemModelDataAccepted(boolean lightingSystemModelDataAccepted) {
        this.lightingSystemModelDataAccepted = lightingSystemModelDataAccepted;
    }

    public String getNotes() {
        return notes;
    }

    public Building setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Set<ExternalIdentifier> getIdentifiers() {
        return identifiers;
    }

    public Building setIdentifiers(Set<ExternalIdentifier> identifiers) {
        this.identifiers = identifiers;
        return this;
    }

    public LocationAddress getLocationDetails() {
        return locationDetails;
    }

    public Building setLocationDetails(LocationAddress locationDetails) {
        this.locationDetails = locationDetails;
        return this;
    }

    public Set<BuildingImage> getImages() {
        return images;
    }

    public void setImages(Set<BuildingImage> images) {
        this.images = images;
    }

    public enum GrossFloorAreaUnitsType {
        SQUARE_FEET("Square Feet", "Sq. Ft."),
        SQUARE_METERS("Square Meters", "Sq. M.");

        private final String value;
        private final String abbreviation;

        GrossFloorAreaUnitsType(String value, String abbreviation) {
            this.value = value;
            this.abbreviation = abbreviation;
        }

        public String value() {
            return this.value;
        }

        public String abbreviation() {
            return this.abbreviation;
        }

        public static GrossFloorAreaUnitsType fromValue(String value) {
            for (GrossFloorAreaUnitsType type : values()) {
                if (type.value.equals(value)) {
                    return type;
                }
            }

            throw new IllegalArgumentException("Unknown GFA Unit Type: " + value);
        }

        public static GrossFloorAreaUnitsType fromAbbreviation(String abbreviation) {
            for (GrossFloorAreaUnitsType type: values()) {
                if (type.abbreviation.equals(abbreviation)) {
                    return type;
                }
            }

            throw new IllegalArgumentException(abbreviation);
        }
    }

    public enum PrimaryBuildingType {
        HOTEL("Hotel"),
        OFFICE("Office"),
        HOSPITAL("Hospital (General Medical & Surgical)"),
        APARTMENT("Multifamily Housing"),
        DATA_CENTER("Data Center"),
        PRIMARY_SCHOOL("Primary School"),
        SECONDARY_SCHOOL("Secondary School (College/University)"),
        FULL_SERVICE_RESTAURANT("Full Service Restaurant"),
        OUTPATIENT_HEALTH_CARE("Outpatient Healthcare"),
        SENIOR_CARE_COMMUNITY("Senior Care Community"),
        QUICK_SERVICE_RESTAURANT("Quick Service/Fastfood Restaurant"),
        STAND_ALONE_RETAIL("Stand Alone Retail"),
        SHOPPING_MALL("Strip/Shopping Mall"),
        SUPERMARKET_GROCERY_STORE("Supermarket/Grocery Store"),
        WHOLESALE_CLUB_SUPERCENTER("Wholesale Club/Supercenter"),
        REFRIGERATED_WAREHOUSE("Refrigerated Warehouse"),
        NON_REFRIGERATED_WAREHOUSE("Non-Refrigerated Warehouse"),
        MANUFACTURING_INDUSTRIAL_PLANT("Manufacturing/Industrial Plant");

        private final String value;

        PrimaryBuildingType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static PrimaryBuildingType fromValue(String value) {
            for (PrimaryBuildingType type : values()) {
                if (type.value.equals(value)) {
                    return type;
                }
            }

            throw new IllegalArgumentException("Unknown building type: " + value);
        }
    }

    public enum Country {
        AE("United Arab Emirates"),
        AL("Albania"),
        AR("Argentina"),
        AT("Austria"),
        AU("Australia"),
        BA("Bosnia and Herzegovina"),
        BE("Belgium"),
        BG("Bulgaria"),
        BH("Bahrain"),
        BO("Bolivia"),
        BR("Brazil"),
        BY("Belarus"),
        CA("Canada"),
        CH("Switzerland"),
        CL("Chile"),
        CN("China"),
        CO("Colombia"),
        CR("Costa Rica"),
        CS("Serbia and Montenegro"),
        CU("Cuba"),
        CY("Cyprus"),
        CZ("Czech Republic"),
        DE("Germany"),
        DK("Denmark"),
        DO("Dominican Republic"),
        DZ("Algeria"),
        EC("Ecuador"),
        EE("Estonia"),
        EG("Egypt"),
        ES("Spain"),
        FI("Finland"),
        FR("France"),
        GB("United Kingdom"),
        GR("Greece"),
        GT("Guatemala"),
        HK("Hong Kong"),
        HN("Honduras"),
        HR("Croatia"),
        HU("Hungary"),
        ID("Indonesia"),
        IE("Ireland"),
        IL("Israel"),
        IN("India"),
        IQ("Iraq"),
        IS("Iceland"),
        IT("Italy"),
        JO("Jordan"),
        JP("Japan"),
        KR("South Korea"),
        KW("Kuwait"),
        LB("Lebanon"),
        LT("Lithuania"),
        LU("Luxembourg"),
        LV("Latvia"),
        LY("Libya"),
        MA("Morocco"),
        ME("Montenegro"),
        MK("Macedonia"),
        MT("Malta"),
        MX("Mexico"),
        MY("Malaysia"),
        NI("Nicaragua"),
        NL("Netherlands"),
        NO("Norway"),
        NZ("New Zealand"),
        OM("Oman"),
        PA("Panama"),
        PE("Peru"),
        PH("Philippines"),
        PL("Poland"),
        PR("Puerto Rico"),
        PT("Portugal"),
        PY("Paraguay"),
        QA("Qatar"),
        RO("Romania"),
        RS("Serbia"),
        RU("Russia"),
        SA("Saudi Arabia"),
        SD("Sudan"),
        SE("Sweden"),
        SG("Singapore"),
        SI("Slovenia"),
        SK("Slovakia"),
        SV("El Salvador"),
        SY("Syria"),
        TH("Thailand"),
        TN("Tunisia"),
        TR("Turkey"),
        TW("Taiwan"),
        UA("Ukraine"),
        US("United States"),
        UY("Uruguay"),
        VE("Venezuela"),
        VN("Vietnam"),
        YE("Yemen"),
        ZA("South Africa");

        private final String country;

        Country(String country) {
            this.country = country;
        }

        public String getCountry() {
            return country;
        }

        public static Country fromValue(String country) {

            for (Country cn : values()) {
                if (cn.country.equals(country)) {
                    return cn;
                }
            }
            throw new IllegalArgumentException("Unknown country code: " + country);
        }
    }
}
