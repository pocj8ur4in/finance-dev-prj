package finance.dev.domain.admin;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import lombok.Builder;
import org.springframework.stereotype.Service;

@TypeInfo(name = "CompanyAdminService", description = "관리자 서비스 클래스")
@Service
public class CompanyAdminService {
    private final CompanyAdminRepository companyAdminRepository;

    @Builder
    public CompanyAdminService(CompanyAdminRepository companyAdminRepository) {
        this.companyAdminRepository = companyAdminRepository;
    }
}
