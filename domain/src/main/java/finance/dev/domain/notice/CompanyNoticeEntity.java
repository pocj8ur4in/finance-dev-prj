package finance.dev.domain.notice;

import finance.dev.common.annotation.TypeInfo;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@TypeInfo(name = "CompanyNoticeEntity", description = "회사 공지사항 엔티티 클래스")
@Entity
@Table(name = "company_notice")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyNoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_idx")
    private Long noticeIdx;

    @Column(name = "notice_title", nullable = false)
    private String noticeTitle;

    @Column(name = "notice_content", nullable = false, length = 2000)
    private String noticeContent;

    @Column(name = "notice_member_id", nullable = false)
    private String noticeMemberId;

    @Column(name = "notice_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date noticeDate;

    @Builder
    public CompanyNoticeEntity(String noticeTitle, String noticeContent, String noticeMemberId) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeMemberId = noticeMemberId;
    }
}
