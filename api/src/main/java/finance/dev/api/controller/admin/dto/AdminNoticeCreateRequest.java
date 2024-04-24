package finance.dev.api.controller.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminNoticeCreateRequest {
    private final String accessToken;
    private final String noticeTitle;
    private final String noticeContent;

    @Builder
    public AdminNoticeCreateRequest(String accessToken, String noticeTitle, String noticeContent) {
        this.accessToken = accessToken;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
    }
}
