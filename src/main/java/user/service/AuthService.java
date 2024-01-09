package user.service;

import user.dto.request.LoginRequest;
import user.dto.response.LoginResponse;
import user.dto.response.common.CommonSuccessResponse;

public interface AuthService {
    CommonSuccessResponse<LoginResponse> login(LoginRequest request);
}
