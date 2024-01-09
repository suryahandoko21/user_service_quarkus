package user.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.jwt.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.constant.HttpConstant;
import user.dto.request.LoginRequest;
import user.dto.response.LoginResponse;
import user.dto.response.UserResponse;
import user.dto.response.common.CommonSuccessResponse;
import user.exception.CustomException;
import user.model.User;

import java.util.Optional;

@ApplicationScoped
public class AuthServiceImpl extends CommonService implements AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Override
    public CommonSuccessResponse<LoginResponse> login(LoginRequest request) throws CustomException {
        logger.info("login LoginRequest: {}", request);

        Optional<User> userOptional = User.find("email", request.getEmail()).firstResultOptional();
        if(userOptional.isEmpty()) {
            throw new CustomException(HttpConstant.LOGIN_FAILED);
        }
        BCrypt.Result verifyPassword = BCrypt.verifyer().verify(request.getPassword().toCharArray(), userOptional.get().getPassword());

        if(!verifyPassword.verified) {
            throw new CustomException(HttpConstant.LOGIN_FAILED);
        }

        var token = Jwt.groups(userOptional.get().getRole().toString())
                        .claim(Claims.email.name(), userOptional.get().getEmail())
                        .claim(Claims.kid.name(), userOptional.get().getId())
                        .subject("user")
                        .expiresIn(3600)
                        .sign();

        return new CommonSuccessResponse<>(LoginResponse.builder().
                user(UserResponse.builder().
                        email(userOptional.get().getEmail()).
                        name(userOptional.get().getName()).
                        build()).
                token(token).
                build());
    }
}
