package finance.dev.domain.notice;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import finance.dev.common.type.*;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import lombok.Builder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@TypeInfo(name = "CompanyNoticeService", description = "회사 공지사항 서비스 클래스")
@Service
public class CompanyNoticeService {
    private final EntityManager entityManager;
    private final CompanyNoticeRepository companyNoticeRepository;

    @Builder
    public CompanyNoticeService(
            CompanyNoticeRepository companyNoticeRepository, EntityManager entityManager) {
        this.companyNoticeRepository = companyNoticeRepository;
        this.entityManager = entityManager;
    }
}
