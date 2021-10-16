/*
 * Developed by Luis (@realluuuuuis)
 * Last modified 16.10.21, 20:48
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster.rest.auth;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class APIKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    private final String principalRequestHeader;

    public APIKeyAuthFilter(String principalRequestHeader) {
        this.principalRequestHeader = principalRequestHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader(principalRequestHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        return null;
    }
}
