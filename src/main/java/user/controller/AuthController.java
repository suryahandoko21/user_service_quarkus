package user.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.dto.request.LoginRequest;
import user.dto.request.RegisterRequest;
import user.service.AuthService;
import user.service.UserService;

@Path("/v1/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @Inject
    public AuthController(
            AuthService authService
    ) {
        this.authService = authService;
    }

    @POST
    public Response login(@Valid LoginRequest request){
        return Response.ok(this.authService.login(request)).build();
    }
}
