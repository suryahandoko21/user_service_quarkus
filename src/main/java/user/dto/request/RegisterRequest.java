package user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import user.constant.Role;
import user.validator.RoleEnumValidator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RegisterRequest {
    @Email
    @NotBlank(message = "email may not be blank")
    private String email;

    @NotBlank(message = "password may not be blank")
    private String password;

    @NotBlank(message = "name may not be blank")
    private String name;

    @RoleEnumValidator(anyOf = {Role.ADMIN, Role.USER}, message = "role must be one of ADMIN, USER")
    private Role role;
}
