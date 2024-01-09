package user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequest {
    @Email
    @NotBlank(message = "email may not be blank")
    private String email;

    @NotBlank(message = "password may not be blank")
    private String password;
}
