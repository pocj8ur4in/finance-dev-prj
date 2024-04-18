package finance.dev.domain.qna;

import finance.dev.common.annotation.TypeInfo;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@TypeInfo(name = "CompanyQnaEntity", description = "회사 Q&A 엔티티 클래스")
@Entity
@Table(name = "company_qna")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyQnaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_idx")
    private Long qnaIdx;

    @Column(name = "qna_name", nullable = false)
    private String qnaName;

    @Column(name = "qna_pw", nullable = false)
    private String qnaPw;

    @Column(name = "qna_title", nullable = false)
    private String qnaTitle;

    @Column(name = "qna_content", nullable = false, length = 2000)
    private String qnaContent;

    @Column(name = "qna_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date qnaDate;

    @Builder
    public CompanyQnaEntity(String qnaName, String qnaPw, String qnaTitle, String qnaContent) {
        this.qnaName = qnaName;
        this.qnaPw = qnaPw;
        this.qnaTitle = qnaTitle;
        this.qnaContent = qnaContent;
    }
}
