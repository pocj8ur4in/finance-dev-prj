package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberFindPwRequest {
    private final String memberId;
    private final String memberName;
    private final String memberEmail;

    @Builder
    public MemberFindPwRequest(String memberId, String memberName, String memberEmail) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
    }
}
