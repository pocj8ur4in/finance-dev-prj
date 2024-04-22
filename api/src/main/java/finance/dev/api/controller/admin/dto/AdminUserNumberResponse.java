package finance.dev.api.controller.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminUserNumberResponse {
    private final int memberNumber;

    @Builder
    public AdminUserNumberResponse(int memberNumber) {
        this.memberNumber = memberNumber;
    }
}
