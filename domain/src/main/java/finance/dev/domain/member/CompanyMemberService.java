package finance.dev.domain.member;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import finance.dev.common.type.AdminPageSize;
import finance.dev.common.type.AdminSort;
import finance.dev.common.type.AdminUserType;
import java.util.ArrayList;
import lombok.Builder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@TypeInfo(name = "CompanyMemberService", description = "회사 회원 서비스 클래스")
@Service
public class CompanyMemberService {
    private final CompanyMemberRepository companyMemberRepository;


    @Builder
    public CompanyMemberService(CompanyMemberRepository companyMemberRepository) {
        this.companyMemberRepository = companyMemberRepository;
    }
}
