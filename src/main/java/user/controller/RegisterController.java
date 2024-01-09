package user.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.dto.request.RegisterRequest;
import user.service.UserService;

@Path("/v1/register")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    private final UserService userService;

    @Inject
    public RegisterController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @POST
    public Response register(@Valid RegisterRequest request){
        return Response.ok(this.userService.saveUser(request)).build();
    }
}
