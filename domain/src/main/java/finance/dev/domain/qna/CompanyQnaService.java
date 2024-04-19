package finance.dev.domain.qna;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import finance.dev.common.type.MemberType;
import java.util.ArrayList;
import lombok.Builder;
import org.springframework.stereotype.Service;

@TypeInfo(name = "CompanyQnaService", description = "회사 QnA 서비스 클래스")
@Service
public class CompanyQnaService {
    private final CompanyQnaRepository companyQnaRepository;


    @Builder
    public CompanyQnaService(CompanyQnaRepository companyQnaRepository) {
        this.companyQnaRepository = companyQnaRepository;
    }
}
