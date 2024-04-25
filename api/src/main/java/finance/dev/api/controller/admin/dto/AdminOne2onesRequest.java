package finance.dev.api.controller.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminOne2onesRequest {
    private final String accessToken;

    @Builder
    public AdminOne2onesRequest(String accessToken) {
        this.accessToken = accessToken;
    }
}
