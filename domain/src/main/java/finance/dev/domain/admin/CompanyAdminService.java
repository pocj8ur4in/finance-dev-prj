package finance.dev.domain.admin;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import lombok.Builder;
import org.springframework.stereotype.Service;

@TypeInfo(name = "CompanyAdminService", description = "관리자 서비스 클래스")
@Service
public class CompanyAdminService {
    private final CompanyAdminRepository companyAdminRepository;

    @MethodInfo(name = "findMemberId", description = "아이디로 회원을 조회합니다.")
    public CompanyAdminEntity findMemberId(String memberId) {
        return companyAdminRepository.findByMemberId(memberId);
    }

    @MethodInfo(name = "checkId", description = "아이디 중복을 체크합니다.")
    public boolean checkId(String memberId) {
        return !companyAdminRepository.existsByMemberId(memberId);
    }

    @Builder
    public CompanyAdminService(CompanyAdminRepository companyAdminRepository) {
        this.companyAdminRepository = companyAdminRepository;
    }
}
