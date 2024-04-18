package finance.dev.domain.product;

import finance.dev.common.annotation.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyProductRepository", description = "회사 제품 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyProductRepository extends JpaRepository<CompanyProductEntity, Long> {}
