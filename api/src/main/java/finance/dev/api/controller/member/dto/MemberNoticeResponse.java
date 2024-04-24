package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberNoticeResponse {
    private final int noticeId;
    private final String noticeTitle;
    private final String noticeDate;
    private final String noticeMemberId;
    private final String noticeContent;

    @Builder
    public MemberNoticeResponse(
            int noticeId,
            String noticeTitle,
            String noticeDate,
            String noticeMemberId,
            String noticeContent) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeDate = noticeDate;
        this.noticeMemberId = noticeMemberId;
        this.noticeContent = noticeContent;
    }
}
