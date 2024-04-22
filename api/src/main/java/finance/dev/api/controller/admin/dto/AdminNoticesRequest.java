package finance.dev.api.controller.admin.dto;

import finance.dev.common.type.AdminNoticeType;
import finance.dev.common.type.AdminPageSize;
import finance.dev.common.type.AdminSort;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminNoticesRequest {
    private final String accessToken;
    private final AdminNoticeType searchType;
    private final String searchContent;
    private final AdminSort searchSort;
    private final AdminPageSize searchPageSize;
    private final int searchPageNumber;

    @Builder
    public AdminNoticesRequest(
            String accessToken,
            AdminNoticeType searchType,
            String searchContent,
            AdminSort searchSort,
            AdminPageSize searchPageSize,
            int searchPageNumber) {
        this.accessToken = accessToken;
        this.searchType = searchType;
        this.searchContent = searchContent;
        this.searchSort = searchSort;
        this.searchPageSize = searchPageSize;
        this.searchPageNumber = searchPageNumber;
    }
}
