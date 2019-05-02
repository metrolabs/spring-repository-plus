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


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pivotenergy.domain.MultiTenantBaseEntity;
import com.pivotenergy.domain.SecurityAuditorAware;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@NoArgsConstructor
@EntityListeners(SecurityAuditorAware.class)
public class ExternalIdentifier extends MultiTenantBaseEntity<ExternalIdentifier> {

    @NotBlank
    @Column(name = "identifier", nullable = false, length = 128)
    private String identifier;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`building_id`", referencedColumnName = "`id`", insertable = false, updatable = false)
    @JsonIgnore
    private Building building;

    public String getIdentifier() {
        return identifier;
    }

    public ExternalIdentifier setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExternalIdentifier setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ExternalIdentifier setDescription(String description) {
        this.description = description;
        return this;
    }

    public Building getBuilding() {
        return building;
    }

    public ExternalIdentifier setBuilding(Building building) {
        this.building = building;
        return this;
    }
}
