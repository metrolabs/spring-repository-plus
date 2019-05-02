package com.pivotenergy.security;

import com.pivotenergy.domain.account.Role;
import com.pivotenergy.domain.account.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class JWTPrincipal extends org.springframework.security.core.userdetails.User {
    private String id;
    private String groupId;
    private String onBehalfOfGroupId;
    private String locale;
    private String fullName;
    private User.Type type;
    private Set<Role> roles;

    public JWTPrincipal(User user) {
        super(user.getEmail(), user.getPassword(), !user.getEnabled(), !user.getExpired(),
                !user.getExpired(), !user.getLocked(),
                user.getRoles().stream()
                        .map(x -> new SimpleGrantedAuthority(x.getRole()))
                        .collect(Collectors.toSet()));

        this.id = user.getId();
        this.type = user.getType();
        this.roles = user.getRoles();
        this.groupId = user.getGroupId();
        this.locale = user.getLocale();
        this.fullName = String.format("%s %s", user.getFirstName(), user.getLastName());
        this.onBehalfOfGroupId = null;
    }

    public JWTPrincipal(User user, String onBehalfOfGroupId) {
        super(user.getEmail(), user.getPassword(), !user.getEnabled(), !user.getExpired(),
                !user.getExpired(), !user.getLocked(),
                user.getRoles().stream()
                        .map(x -> new SimpleGrantedAuthority(x.getRole()))
                        .collect(Collectors.toSet()));

        this.id = user.getId();
        this.type = user.getType();
        this.roles = user.getRoles();
        this.groupId = user.getGroupId();
        this.locale = user.getLocale();
        this.fullName = String.format("%s %s", user.getFirstName(), user.getLastName());
        this.onBehalfOfGroupId = onBehalfOfGroupId;
    }

    public JWTPrincipal(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public JWTPrincipal(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public String getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getOBOGroupIdOrUserGroupId() {
        return Optional.ofNullable(onBehalfOfGroupId).orElse(groupId);
    }

    public String getLocale() {
        return locale;
    }

    public String getFullName() {
        return fullName;
    }

    public User.Type getType() {
        return type;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
