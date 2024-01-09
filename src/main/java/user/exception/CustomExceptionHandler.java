package user.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import user.dto.response.common.CommonResponse;

import static user.constant.HttpConstant.MAP_RESPONSE_ERROR;

public class CustomExceptionHandler implements ExceptionMapper<CustomException> {
    @Override
    public Response toResponse(CustomException e) {
        CommonResponse response = MAP_RESPONSE_ERROR.get(e.getMessage());
        return Response.status(response.getStatus()).entity(response.getMessage()).build();
    }

}
