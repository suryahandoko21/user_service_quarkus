package user.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.constant.HttpConstant;
import user.dto.request.RegisterRequest;
import user.dto.response.UserResponse;
import user.dto.response.common.CommonResponse;
import user.dto.response.common.CommonSuccessResponse;
import user.exception.CustomException;
import user.model.User;

import java.util.Optional;

@ApplicationScoped
public class UserServiceImpl extends CommonService implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Transactional
    public CommonSuccessResponse<CommonResponse> saveUser(RegisterRequest registerRequest) {
        logger.info("saveUser registerRequest: {}", registerRequest);
        User.builder().
            name(registerRequest.getName()).
            email(registerRequest.getEmail()).
            password(BCrypt.withDefaults().hashToString(12, registerRequest.getPassword().toCharArray())).
            role(registerRequest.getRole()).
            build().
            persist();
        return new CommonSuccessResponse<>(CommonResponse.builder().status(Response.Status.OK).message(null).build());
    }

    @Override
    public CommonSuccessResponse<UserResponse> getUserById(String id) {
        logger.info("getUserById id: {}", id);
        Optional<User> user = User.findByIdOptional(id);
        if (user.isEmpty()) {
            throw new CustomException(HttpConstant.USER_NOT_FOUND);
        }
        return new CommonSuccessResponse<>(UserResponse.builder().
                email(user.get().getEmail()).
                name(user.get().getName()).
                build());
    }
}
