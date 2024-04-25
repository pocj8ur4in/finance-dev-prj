package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberOne2oneRequest {
    private final String accessToken;
    private final String one2oneName;
    private final String one2oneEmail;
    private final String one2onePhone;
    private final String one2oneAddress;
    private final String one2oneTitle;
    private final String one2oneContent;
    private final String one2oneDate;

    @Builder
    public MemberOne2oneRequest(
            String accessToken,
            String one2oneName,
            String one2oneEmail,
            String one2onePhone,
            String one2oneAddress,
            String one2oneTitle,
            String one2oneContent,
            String one2oneDate) {
        this.accessToken = accessToken;
        this.one2oneName = one2oneName;
        this.one2oneEmail = one2oneEmail;
        this.one2onePhone = one2onePhone;
        this.one2oneAddress = one2oneAddress;
        this.one2oneTitle = one2oneTitle;
        this.one2oneContent = one2oneContent;
        this.one2oneDate = one2oneDate;
    }
}
