package com.pivotenergy.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pivotenergy.domain.MultiTenantBaseEntity;
import com.pivotenergy.domain.SecurityAuditorAware;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@NoArgsConstructor
@EntityListeners(SecurityAuditorAware.class)
public class UserRefreshToken extends MultiTenantBaseEntity<UserRefreshToken> {

    @NotEmpty
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @ManyToOne
    @JoinColumn(name = "`user_id`", referencedColumnName = "`id`", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    public String getToken() {
        return token;
    }

    public UserRefreshToken setToken(String token) {
        this.token = token;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserRefreshToken setUser(User user) {
        this.user = user;
        return this;
    }
}
