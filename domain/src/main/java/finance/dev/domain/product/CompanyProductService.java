package finance.dev.domain.product;

import finance.dev.common.annotation.TypeInfo;
import lombok.Builder;
import org.springframework.stereotype.Service;

@TypeInfo(name = "CompanyProductService", description = "회사 상품 서비스 클래스")
@Service
public class CompanyProductService {
    private final CompanyProductRepository companyProductRepository;

    @Builder
    public CompanyProductService(CompanyProductRepository companyProductRepository) {
        this.companyProductRepository = companyProductRepository;
    }
}
