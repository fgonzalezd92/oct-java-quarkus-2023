package com.herbalife;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/secured")
public class JwtResource {
    @Inject
    JsonWebToken jwt;

    @GET
    @Path("permit-all")
    @PermitAll
    public String hello(@Context SecurityContext ctx) {
        return getResponseString(ctx);
    }

    @GET
    @Path("roles-allowed")
    @RolesAllowed({ "users", "admins" })
    public String helloRolesAllowed(@Context SecurityContext ctx) {
        System.out.println(jwt.getName());
        System.out.println(jwt.getClaimNames());
        System.out.println(jwt.getGroups());
        System.out.println("ctx.getUserPrincipal().getName() = " + ctx.getUserPrincipal().getName());
        return getResponseString(ctx);
    }

    private String getResponseString(SecurityContext ctx) {
        System.out.println("ctx.getUserPrincipal().getName() = " + ctx.getUserPrincipal().getName());
        String name;
        if (ctx.getUserPrincipal() == null) {
            name = "anonymous";
        } else if (!ctx.getUserPrincipal().getName().equals(jwt.getName())) {
            throw new InternalServerErrorException("Principal and JsonWebToken names do not match");
        } else {
            name = ctx.getUserPrincipal().getName();
        }
        return String.format("hello + %s,"
                        + " isHttps: %s,"
                        + " authScheme: %s,"
                        + " hasJWT: %s",
                name, ctx.isSecure(), ctx.getAuthenticationScheme(), hasJwt());
    }

    private boolean hasJwt() {
        return jwt.getClaimNames() != null;
    }
}
