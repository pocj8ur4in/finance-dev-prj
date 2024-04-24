package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberFindPwResponse {
    private final String memberPw;

    @Builder
    public MemberFindPwResponse(String memberPw) {
        this.memberPw = memberPw;
    }
}
