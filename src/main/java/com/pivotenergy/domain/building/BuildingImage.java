package com.pivotenergy.domain.building;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pivotenergy.domain.MultiTenantBaseEntity;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@NoArgsConstructor
public class BuildingImage extends MultiTenantBaseEntity<BuildingImage> {

    @Column(name = "`url`", unique = true)
    @NotBlank
    @URL
    @NonNull
    private String url;

    @Column(name = "`name`")
    @NotBlank
    private String name;

    @Column(name = "`description`")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`building_id`", referencedColumnName = "`id`", insertable = false, updatable = false)
    @JsonIgnore
    private Building building;

    public String getUrl() {
        return url;
    }

    public BuildingImage setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public BuildingImage setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BuildingImage setDescription(String description) {
        this.description = description;
        return this;
    }

    public Building getBuilding() {
        return building;
    }

    public BuildingImage setBuilding(Building building) {
        this.building = building;
        return this;
    }
}

