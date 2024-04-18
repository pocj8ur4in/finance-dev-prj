package finance.dev.domain.one2one;

import finance.dev.common.annotation.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyOne2OneRepository", description = "회사 일대일문의 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyOne2OneRepository extends JpaRepository<CompanyOne2OneEntity, Long> {}
