package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberNoticeRequest {
    private final String accessToken;
    private final int noticeId;

    @Builder
    public MemberNoticeRequest(String accessToken, int noticeId) {
        this.accessToken = accessToken;
        this.noticeId = noticeId;
    }
}
