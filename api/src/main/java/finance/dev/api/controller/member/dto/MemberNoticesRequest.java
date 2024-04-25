package finance.dev.api.controller.member.dto;

import finance.dev.common.type.MemberType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberNoticesRequest {
    private final String accessToken;
    private final MemberType searchType;
    private final String searchContent;

    @Builder
    public MemberNoticesRequest(String accessToken, MemberType searchType, String searchContent) {
        this.accessToken = accessToken;
        this.searchType = searchType;
        this.searchContent = searchContent;
    }
}
