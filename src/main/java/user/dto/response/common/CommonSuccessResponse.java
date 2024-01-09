package user.dto.response.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CommonSuccessResponse<T> {
    private final String message;
    private final String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    public CommonSuccessResponse(T data) {
        this.message = "Success";
        this.code = "200";
        this.data = data;
    }

    public CommonSuccessResponse() {
        this.message = "Success";
        this.code = "200";
        this.data = null;
    }
}
