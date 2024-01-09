package user.dto.response.common;

import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommonResponse {
    CommonErrorResponse message;
    Response.Status status;
}

