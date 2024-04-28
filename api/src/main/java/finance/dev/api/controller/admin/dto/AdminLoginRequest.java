package finance.dev.api.controller.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminLoginRequest {
    private final String memberId;
    private final String memberPw;

    @Builder
    public AdminLoginRequest(String memberId, String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }
}
