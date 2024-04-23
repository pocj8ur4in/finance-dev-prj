package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberFindIdResponse {
    private final String memberId;

    @Builder
    public MemberFindIdResponse(String memberId) {
        this.memberId = memberId;
    }
}
