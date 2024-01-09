package user.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import user.constant.Role;

import java.util.Arrays;

public class RoleEnumSetValidator implements ConstraintValidator<RoleEnumValidator, Role> {
    private Role[] subset;

    @Override
    public void initialize(RoleEnumValidator constraintAnnotation) {
        this.subset = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(Role role, ConstraintValidatorContext constraintValidatorContext) {
        return role == null || Arrays.asList(subset).contains(role);
    }
}
