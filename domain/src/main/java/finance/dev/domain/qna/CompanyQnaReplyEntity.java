package finance.dev.domain.qna;

import finance.dev.common.annotation.TypeInfo;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@TypeInfo(name = "CompanyQnaReplyEntity", description = "회사 Q&A 답글 엔티티 클래스")
@Entity
@Table(name = "company_qna_reply")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyQnaReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_reply_idx")
    private Long qnaReplyIdx;

    @Column(name = "qna_reply_content", nullable = false, length = 2000)
    private String qnaReplyContent;

    @Column(name = "qna_reply_name", nullable = false)
    private String qnaReplyName;

    @Column(
            name = "qna_reply_date",
            nullable = false,
            columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date qnaReplyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qna_reply_qna_idx", nullable = false)
    private CompanyQnaEntity qnaEntity;

    @Builder
    public CompanyQnaReplyEntity(
            String qnaReplyContent, String qnaReplyName, CompanyQnaEntity qnaEntity) {
        this.qnaReplyContent = qnaReplyContent;
        this.qnaReplyName = qnaReplyName;
        this.qnaEntity = qnaEntity;
    }
}
