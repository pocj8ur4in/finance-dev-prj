package finance.dev.api.controller.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminUserResponse {
    private final String memberId;
    private final String memberName;
    private final String memberEmail;
    private final String memberBirthDate;
    private final String memberJoinDate;

    @Builder
    public AdminUserResponse(
            String memberId,
            String memberName,
            String memberEmail,
            String memberBirthDate,
            String memberJoinDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberBirthDate = memberBirthDate;
        this.memberJoinDate = memberJoinDate;
    }
}
