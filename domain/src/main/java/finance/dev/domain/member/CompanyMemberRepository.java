package finance.dev.domain.member;

import finance.dev.common.annotation.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyMemberRepository", description = "회사 회원 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyMemberRepository extends JpaRepository<CompanyMemberEntity, Long> {}
