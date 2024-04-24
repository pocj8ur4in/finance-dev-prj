package finance.dev.domain.notice;

import finance.dev.common.annotation.TypeInfo;
import java.util.ArrayList;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@TypeInfo(name = "CompanyNoticeRepository", description = "회사 공지사항 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyNoticeRepository extends JpaRepository<CompanyNoticeEntity, Long> {
    CompanyNoticeEntity findByNoticeIdx(int noticeId);

    ArrayList<CompanyNoticeEntity> findAllByNoticeTitleContaining(
            Pageable pageable, @Param("searchContent") String searchContent);

    ArrayList<CompanyNoticeEntity> findAllByNoticeContentContaining(
            Pageable pageable, @Param("searchContent") String searchContent);

    ArrayList<CompanyNoticeEntity> findAllByNoticeMemberIdContaining(
            Pageable pageable, @Param("searchContent") String searchContent);

    ArrayList<CompanyNoticeEntity>
            findAllByNoticeTitleContainingOrNoticeContentContainingOrNoticeMemberIdContaining(
                    Pageable pageable,
                    @Param("searchContent1") String searchContent1,
                    @Param("searchContent2") String searchContent2,
                    @Param("searchContent3") String searchContent3);
}
