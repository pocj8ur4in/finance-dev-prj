package finance.dev.domain.one2one;

import finance.dev.common.annotation.TypeInfo;
import jakarta.persistence.*;
import lombok.*;

@TypeInfo(name = "CompanyOne2OneEntity", description = "회사 일대일문의 엔티티 클래스")
@Entity
@Table(name = "company_one2one")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyOne2OneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "one2one_idx")
    private int one2OneIdx;

    @Column(name = "one2one_name", nullable = false)
    private String one2OneName;

    @Column(name = "one2one_phone", nullable = false)
    private String one2OnePhone;

    @Column(name = "one2one_email", nullable = false)
    private String one2OneEmail;

    @Column(name = "one2one_address", nullable = false)
    private String one2OneAddress;

    @Column(name = "one2one_title", nullable = false)
    private String one2OneTitle;

    @Column(name = "one2one_content", nullable = false, length = 2000)
    private String one2OneContent;

    @Column(name = "one2one_date", nullable = false)
    private String one2OneDate;

    @Builder
    public CompanyOne2OneEntity(
            String one2OneName,
            String one2OnePhone,
            String one2OneEmail,
            String one2OneAddress,
            String one2OneTitle,
            String one2OneContent,
            String one2OneDate) {
        this.one2OneName = one2OneName;
        this.one2OnePhone = one2OnePhone;
        this.one2OneEmail = one2OneEmail;
        this.one2OneAddress = one2OneAddress;
        this.one2OneTitle = one2OneTitle;
        this.one2OneContent = one2OneContent;
        this.one2OneDate = one2OneDate;
    }
}
