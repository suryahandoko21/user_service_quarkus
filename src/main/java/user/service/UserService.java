package user.service;

import user.dto.request.RegisterRequest;
import user.dto.response.UserResponse;
import user.dto.response.common.CommonResponse;
import user.dto.response.common.CommonSuccessResponse;

public interface UserService {
    CommonSuccessResponse<CommonResponse> saveUser(RegisterRequest registerRequest);

    CommonSuccessResponse<UserResponse> getUserById(String id);
}
