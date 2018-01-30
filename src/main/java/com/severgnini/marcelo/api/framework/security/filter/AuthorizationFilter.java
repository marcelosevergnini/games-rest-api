package com.severgnini.marcelo.api.framework.security.filter;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.AccessDeniedException;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter  implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        Method method = resourceInfo.getResourceMethod();

        if (method.isAnnotationPresent(DenyAll.class)) {
            throw new AccessDeniedException("You don't have permissions!!");
        }

        if (method.isAnnotationPresent(PermitAll.class)) {
            return;
        }

    }

}
