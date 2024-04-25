package finance.dev.api.controller.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminNoticeUpdateRequest {
    private final String accessToken;
    private final int noticeId;
    private final String noticeTitle;
    private final String noticeContent;

    @Builder
    public AdminNoticeUpdateRequest(
            String accessToken, int noticeId, String noticeTitle, String noticeContent) {
        this.accessToken = accessToken;
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
    }
}
