package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberJoinRequest {
    private final String memberId;
    private final String memberPw;
    private final String memberPwConfirm;

    private final String memberName;
    private final String memberEmail;
    private final int memberEmailReceive;
    private final int memberPwQuestion;
    private final String memberPwAnswer;
    private final String memberGender;
    private final String memberBirthDate;

    @Builder
    public MemberJoinRequest(
            String memberId,
            String memberPw,
            String memberPwConfirm,
            String memberName,
            String memberEmail,
            int memberEmailReceive,
            int memberPwQuestion,
            String memberPwAnswer,
            String memberGender,
            String memberBirthDate) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberPwConfirm = memberPwConfirm;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberEmailReceive = memberEmailReceive;
        this.memberPwQuestion = memberPwQuestion;
        this.memberPwAnswer = memberPwAnswer;
        this.memberGender = memberGender;
        this.memberBirthDate = memberBirthDate;
    }
}
