package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberFindIdRequest {
    private final String memberName;
    private final String memberEmail;

    @Builder
    public MemberFindIdRequest(String memberName, String memberEmail) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
    }
}
