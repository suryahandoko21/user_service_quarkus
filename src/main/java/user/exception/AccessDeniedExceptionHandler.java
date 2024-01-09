package user.exception;


import jakarta.ws.rs.ForbiddenException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.nio.file.AccessDeniedException;

@Provider
public class AccessDeniedExceptionHandler implements ExceptionMapper<ForbiddenException> {

    @Override
    public Response toResponse(ForbiddenException exception) {
        return Response.status(Response.Status.FORBIDDEN)
                .entity("Custom message: Access Denied")
                .build();
    }
}
