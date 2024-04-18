package finance.dev.domain.admin;

import finance.dev.common.annotation.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyAdminRepository", description = "회사 관리자 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyAdminRepository extends JpaRepository<CompanyAdminEntity, Long> {}