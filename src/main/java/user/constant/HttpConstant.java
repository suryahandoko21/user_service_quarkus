package user.constant;

import jakarta.ws.rs.core.Response;
import user.dto.response.common.CommonErrorResponse;
import user.dto.response.common.CommonResponse;

import java.util.Map;

public class HttpConstant {

    private HttpConstant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String LOGIN_FAILED = "40001";
    public static final String UNAUTHORIZED = "40101";
    public static final String USER_NOT_FOUND = "40401";
    public static final String INTERNAL_SERVER_ERROR = "50001";
    public static final Map<String, CommonResponse> MAP_RESPONSE_ERROR = Map.of(
            LOGIN_FAILED, mappingResponse(Response.Status.NOT_FOUND, "LOGIN_FAILED", LOGIN_FAILED),
            UNAUTHORIZED, mappingResponse(Response.Status.UNAUTHORIZED, "UNAUTHORIZED", UNAUTHORIZED),
            USER_NOT_FOUND, mappingResponse(Response.Status.NOT_FOUND, "USER_NOT_FOUND", USER_NOT_FOUND),
            INTERNAL_SERVER_ERROR, mappingResponse(Response.Status.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", INTERNAL_SERVER_ERROR)
    );

    private static CommonResponse mappingResponse(Response.Status httpCode, String message, String code) {
        return new CommonResponse(CommonErrorResponse.builder().message(message).code(code).build(), httpCode);
    }
}
