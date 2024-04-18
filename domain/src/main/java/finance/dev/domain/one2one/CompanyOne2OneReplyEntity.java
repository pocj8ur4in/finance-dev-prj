package finance.dev.domain.one2one;

import finance.dev.common.annotation.TypeInfo;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@TypeInfo(name = "CompanyOne2OneReplyEntity", description = "회사 일대일문의 답글 엔티티 클래스")
@Entity
@Table(name = "company_one2one_reply")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyOne2OneReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "one2one_reply_idx")
    private Long one2OneReplyIdx;

    @Column(name = "one2one_reply_content", nullable = false, length = 2000)
    private String one2OneReplyContent;

    @Column(name = "one2one_reply_name", nullable = false)
    private String one2OneReplyName;

    @Column(
            name = "one2one_reply_date",
            nullable = false,
            columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date one2OneReplyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "one2one_reply_one2one_idx", nullable = false)
    private CompanyOne2OneEntity one2OneEntity;

    @Builder
    public CompanyOne2OneReplyEntity(
            String one2OneReplyContent,
            String one2OneReplyName,
            CompanyOne2OneEntity one2OneEntity) {
        this.one2OneReplyContent = one2OneReplyContent;
        this.one2OneReplyName = one2OneReplyName;
        this.one2OneEntity = one2OneEntity;
    }
}
