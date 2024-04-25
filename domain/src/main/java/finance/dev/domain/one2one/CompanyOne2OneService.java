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

    @MethodInfo(name = "createOne2One", description = "일대일 문의를 생성합니다.")
    public void createOne2One(CompanyOne2OneEntity companyOne2OneEntity) {
        companyOne2OneRepository.save(companyOne2OneEntity);
    }

    @MethodInfo(name = "count", description = "일대일 문의의 개수를 반환합니다.")
    public long count() {
        return companyOne2OneRepository.count();
    }

    @MethodInfo(name = "findAll", description = "모든 일대일 문의를 반환합니다.")
    public List<CompanyOne2OneEntity> findAll() {
        return companyOne2OneRepository.findAll();
    }

    @Builder
    public CompanyOne2OneService(CompanyOne2OneRepository companyOne2OneRepository) {
        this.companyOne2OneRepository = companyOne2OneRepository;
    }
}
