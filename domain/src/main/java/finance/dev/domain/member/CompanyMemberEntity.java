package finance.dev.domain.member;

import finance.dev.common.annotation.TypeInfo;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@TypeInfo(name = "CompanyMemberEntity", description = "회사 회원 엔티티 클래스")
@Table(name = "company_member")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_idx")
    private int memberIdx;

    @Column(name = "member_id", unique = true, nullable = false)
    private String memberId;

    @Column(name = "member_pw", nullable = false)
    private String memberPw;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "member_email", unique = true, nullable = false)
    private String memberEmail;

    @Column(name = "member_email_receive", nullable = false)
    private int memberEmailReceive;

    @Column(name = "member_pw_question", nullable = false)
    private int memberPwQuestion;

    @Column(name = "member_pw_answer", nullable = false)
    private String memberPwAnswer;

    @Column(name = "member_gender", nullable = false)
    private String memberGender;

    @Column(name = "member_birth_date", nullable = false)
    private String memberBirthDate;

    @Column(name = "member_join_date", nullable = false)
    private LocalDateTime memberJoinDate;

    @Builder
    public CompanyMemberEntity(
            String memberId,
            String memberPw,
            String memberName,
            String memberEmail,
            int memberEmailReceive,
            int memberPwQuestion,
            String memberPwAnswer,
            String memberGender,
            LocalDateTime memberJoinDate,
            String memberBirthDate) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberEmailReceive = memberEmailReceive;
        this.memberPwQuestion = memberPwQuestion;
        this.memberPwAnswer = memberPwAnswer;
        this.memberGender = memberGender;
        this.memberJoinDate = memberJoinDate;
        this.memberBirthDate = memberBirthDate;
    }
}
