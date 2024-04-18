package finance.dev.domain.qna;

import finance.dev.common.annotation.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyQnaRepository", description = "회사 Q&A 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyQnaRepository extends JpaRepository<CompanyQnaEntity, Long> {}
