package finance.dev.domain.qna;

import finance.dev.common.annotation.TypeInfo;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TypeInfo(name = "CompanyQnaRepository", description = "회사 Q&A 레포지토리 인터페이스")
@EnableJpaRepositories
public interface CompanyQnaRepository extends JpaRepository<CompanyQnaEntity, Long> {
    CompanyQnaEntity findByQnaIdx(int qnaId);

    ArrayList<CompanyQnaEntity> findAllByQnaTitleContaining(String searchContent);

    ArrayList<CompanyQnaEntity> findAllByQnaContentContaining(String searchContent);

    ArrayList<CompanyQnaEntity> findAllByQnaNameContaining(String searchContent);

    ArrayList<CompanyQnaEntity>
            findAllByQnaTitleContainingOrQnaContentContainingOrQnaNameContaining(
                    String searchContent1, String searchContent2, String searchContent3);
}
