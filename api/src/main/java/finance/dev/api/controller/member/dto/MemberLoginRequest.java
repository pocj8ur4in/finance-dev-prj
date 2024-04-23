package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberLoginRequest {
    private final String memberId;
    private final String memberPw;

    @Builder
    public MemberLoginRequest(String memberId, String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }
}
