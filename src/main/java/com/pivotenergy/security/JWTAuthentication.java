package com.pivotenergy.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pivotenergy.domain.account.Role;
import com.pivotenergy.security.response.TokenPair;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Represents all information, which has been extracted from JWT
 */
@SuppressWarnings("unused")
@JsonInclude(value = NON_NULL)
public class JWTAuthentication extends UsernamePasswordAuthenticationToken {

    public JWTAuthentication(Object principal, Object credentials, Collection<Role> authorities) {
        super(principal, credentials, authorities.stream()
                .map(x -> new SimpleGrantedAuthority(x.getRole()))
                .collect(Collectors.toSet()));
    }

    @JsonIgnore
    public TokenPair getTokenPair() {
        return (TokenPair) super.getDetails();
    }

    @Override
    public JWTPrincipal getPrincipal() {
        return (JWTPrincipal) super.getPrincipal();
    }

    public JWTAuthentication setTokenPair(TokenPair tokenPair) {
        super.setDetails(tokenPair);
        return this;
    }
}
