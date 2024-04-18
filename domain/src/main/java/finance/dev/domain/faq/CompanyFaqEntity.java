package finance.dev.domain.faq;

import finance.dev.common.annotation.TypeInfo;
import jakarta.persistence.*;
import lombok.*;

@TypeInfo(name = "CompanyFaqEntity", description = "회사 FAQ 엔티티 클래스")
@Entity
@Table(name = "company_faq")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyFaqEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faq_idx")
    private Long faqIdx;

    @Column(name = "faq_title", nullable = false)
    private String faqTitle;

    @Column(name = "faq_content", nullable = false, length = 2000)
    private String faqContent;

    @Builder
    public CompanyFaqEntity(String faqTitle, String faqContent) {
        this.faqTitle = faqTitle;
        this.faqContent = faqContent;
    }
}
