package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberQnaRequest {
    private final String accessToken;
    private final int qnaId;
    private final String memberPw;

    @Builder
    public MemberQnaRequest(String accessToken, int qnaId, String memberPw) {
        this.accessToken = accessToken;
        this.qnaId = qnaId;
        this.memberPw = memberPw;
    }
}
