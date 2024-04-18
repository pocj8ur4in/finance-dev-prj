package finance.dev.domain.qna;

import finance.dev.common.annotation.TypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyQnaReplyRepository", description = "회사 Q&A 답글 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyQnaReplyRepository extends JpaRepository<CompanyQnaReplyEntity, Long> {}
