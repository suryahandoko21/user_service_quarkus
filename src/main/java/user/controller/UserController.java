package user.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import user.service.UserService;

@Path("/v1/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class UserController {

    private final String userID;
    private final UserService userService;

    @Inject
    public UserController(
            @Claim(standard = Claims.kid)
            String userID,
            UserService userService
    ){
        this.userID = userID;
        this.userService = userService;
    }


    @GET
    @RolesAllowed({ "USER", "ADMIN" })
    public Response getUser(){
        return Response.ok(this.userService.getUserById(userID)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "ADMIN" })
    public Response getUserById(
            @PathParam("id")
            String id
    ){
        return Response.ok(this.userService.getUserById(id)).build();
    }
}
