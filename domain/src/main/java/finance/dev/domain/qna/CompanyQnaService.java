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

    @MethodInfo(name = "searchByMember", description = "회원 조건으로 QnA를 검색합니다.")
    public ArrayList<CompanyQnaEntity> searchByMember(MemberType searchType, String searchContent) {
        if (searchType == MemberType.NAME) {
            return new ArrayList<>(companyQnaRepository.findAllByQnaTitleContaining(searchContent));
        } else if (searchType == MemberType.CONTENT) {
            return new ArrayList<>(
                    companyQnaRepository.findAllByQnaContentContaining(searchContent));
        } else if (searchType == MemberType.AUTHOR) {
            return new ArrayList<>(companyQnaRepository.findAllByQnaNameContaining(searchContent));
        } else {
            return new ArrayList<>(
                    companyQnaRepository
                            .findAllByQnaTitleContainingOrQnaContentContainingOrQnaNameContaining(
                                    searchContent, searchContent, searchContent));
        }
    }

    @MethodInfo(name = "findQna", description = "QnA를 조회합니다.")
    public CompanyQnaEntity findQna(int qnaId) {
        return companyQnaRepository.findById((long) qnaId).orElse(null);
    }

    @Builder
    public CompanyQnaService(CompanyQnaRepository companyQnaRepository) {
        this.companyQnaRepository = companyQnaRepository;
    }
}
