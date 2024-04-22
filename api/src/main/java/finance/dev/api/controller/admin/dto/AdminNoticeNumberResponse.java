package finance.dev.api.controller.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminNoticeNumberResponse {
    private final int noticeNumber;

    @Builder
    public AdminNoticeNumberResponse(int noticeNumber) {
        this.noticeNumber = noticeNumber;
    }
}
