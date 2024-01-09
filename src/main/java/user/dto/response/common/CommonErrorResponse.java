package user.dto.response.common;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonErrorResponse {
    private String message;
    private String code;
}
