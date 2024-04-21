package finance.dev.api.controller.admin.dto;

import finance.dev.common.type.AdminPageSize;
import finance.dev.common.type.AdminSort;
import finance.dev.common.type.AdminUserType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminUsersRequest {
    private final String accessToken;
    private final AdminUserType searchType;
    private final String searchContent;
    private final AdminSort searchSort;
    private final int searchPageNum;
    private final AdminPageSize searchPageSize;

    @Builder
    public AdminUsersRequest(
            String accessToken,
            AdminUserType searchType,
            String searchContent,
            AdminSort searchSort,
            int searchPageNum,
            AdminPageSize searchPageSize) {
        this.accessToken = accessToken;
        this.searchType = searchType;
        this.searchContent = searchContent;
        this.searchSort = searchSort;
        this.searchPageNum = searchPageNum;
        this.searchPageSize = searchPageSize;
    }
}
