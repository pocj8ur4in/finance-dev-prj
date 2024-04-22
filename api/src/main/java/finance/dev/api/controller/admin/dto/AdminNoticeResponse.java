package finance.dev.api.controller.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminNoticeResponse {
    private final int noticeId;
    private final String noticeTitle;
    private final String noticeContent;
    private final String noticeMemberId;
    private final String noticeDate;

    @Builder
    public AdminNoticeResponse(
            int noticeId,
            String noticeTitle,
            String noticeContent,
            String noticeMemberId,
            String noticeDate) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeMemberId = noticeMemberId;
        this.noticeDate = noticeDate;
    }
}
