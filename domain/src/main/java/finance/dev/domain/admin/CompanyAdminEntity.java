package finance.dev.domain.admin;

import finance.dev.common.annotation.TypeInfo;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@TypeInfo(name = "CompanyAdminEntity", description = "회사 관리자 엔티티 클래스")
@Entity
@Table(name = "company_member_admin")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyAdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_idx")
    private Long memberIdx;

    @Column(name = "member_id", unique = true, nullable = false)
    private String memberId;

    @Column(name = "member_pw", nullable = false)
    private String memberPw;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "member_email", unique = true, nullable = false)
    private String memberEmail;

    @Column(
            name = "member_join_date",
            nullable = false,
            columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date memberJoinDate;

    @Builder
    public CompanyAdminEntity(
            String memberId, String memberPw, String memberName, String memberEmail) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
    }
}
