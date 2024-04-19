package finance.dev.domain.one2one;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import java.util.List;
import lombok.Builder;
import org.springframework.stereotype.Service;

@TypeInfo(name = "CompanyOne2OneService", description = "일대일 문의 서비스 클래스")
@Service
public class CompanyOne2OneService {
    private final CompanyOne2OneRepository companyOne2OneRepository;


    @Builder
    public CompanyOne2OneService(CompanyOne2OneRepository companyOne2OneRepository) {
        this.companyOne2OneRepository = companyOne2OneRepository;
    }
}
