package finance.dev.domain.faq;

import finance.dev.common.annotation.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyFaqRepository", description = "회사 FAQ 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyFaqRepository extends JpaRepository<CompanyFaqEntity, Long> {}
