package com.pivotenergy.domain;

import com.pivotenergy.security.JWTAuthentication;
import com.pivotenergy.security.JWTPrincipal;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Log4j
public abstract class MultiTenantBaseEntity<T> extends BaseEntity<T> implements MultiTenant<T> {
    @NotNull
    protected String groupId;

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public T setGroupId(String groupId) {
        this.groupId = groupId;
        //noinspection unchecked
        return (T) this;
    }

    @PrePersist
    public void methodInvokedBeforePersist() {
        log.debug(String.format("Invoked before persisting %s", this.getClass().getSimpleName()));
        setTenantGroupId();
    }

    @PreUpdate
    public void methodInvokedBeforeUpdate() {
        log.debug(String.format("Invoked before updating %s", this.getClass().getSimpleName()));
        setTenantGroupId();
    }

    private void setTenantGroupId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && auth instanceof JWTAuthentication) {
            if(null != auth.getPrincipal() && auth.getPrincipal() instanceof JWTPrincipal) {
                this.groupId = ((JWTPrincipal) auth.getPrincipal()).getOBOGroupIdOrUserGroupId();
                log.debug(String.format("Setting groupId=%s", this.groupId));
            }
        }
    }
}
