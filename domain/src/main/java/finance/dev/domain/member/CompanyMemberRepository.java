package finance.dev.domain.member;

import finance.dev.common.annotation.TypeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyMemberRepository", description = "회사 회원 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyMemberRepository extends JpaRepository<CompanyMemberEntity, Long> {
    boolean existsByMemberId(String memberId);
    Page<CompanyMemberEntity> findAllByMemberIdContaining(String memberId, Pageable pageable);

    Page<CompanyMemberEntity> findAllByMemberNameContaining(String memberName, Pageable pageable);

    Page<CompanyMemberEntity> findAllByMemberEmailContaining(String memberEmail, Pageable pageable);

    Page<CompanyMemberEntity>
            findAllByMemberIdContainingOrMemberNameContainingOrMemberEmailContaining(
                    String memberId, String memberName, String memberEmail, Pageable pageable);
}
