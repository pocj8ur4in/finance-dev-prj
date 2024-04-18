package finance.dev.domain.notice;

import finance.dev.common.annotation.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyNoticeRepository", description = "회사 공지사항 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyNoticeRepository extends JpaRepository<CompanyNoticeEntity, Long> {}
