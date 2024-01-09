package user.exception;

import io.quarkus.security.AuthenticationFailedException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AuthenticationFailedExceptionHandler implements ExceptionMapper<AuthenticationFailedException> {

    @Override
    public Response toResponse(AuthenticationFailedException e) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("Custom message: Authentication Failed")
                .build();
    }
}
