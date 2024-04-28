package finance.dev.api.controller.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminLoginResponse {
    private final String accessToken;
    private final String refreshToken;

    @Builder
    public AdminLoginResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
