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

    @MethodInfo(name = "searchByAdmin", description = "관리자가 회사 회원을 검색합니다.")
    public ArrayList<CompanyMemberEntity> searchByAdmin(
            AdminUserType searchType,
            String searchContent,
            int searchPageNum,
            AdminPageSize pageSize,
            AdminSort searchSort) {

        Pageable pageable =
                PageRequest.of(
                        searchPageNum,
                        pageSize == AdminPageSize.SIZE_5
                                ? 5
                                : pageSize == AdminPageSize.SIZE_10 ? 10 : 20,
                        searchSort == AdminSort.ID_ASC
                                ? Sort.by("memberId").ascending()
                                : searchSort == AdminSort.ID_DESC
                                        ? Sort.by("memberId").descending()
                                        : searchSort == AdminSort.JOIN_DATE_ASC
                                                ? Sort.by("memberJoinDate").ascending()
                                                : Sort.by("memberJoinDate").descending());

        if (searchType == AdminUserType.ID) {
            return new ArrayList<>(
                    companyMemberRepository
                            .findAllByMemberIdContaining(searchContent, pageable)
                            .getContent());
        } else if (searchType == AdminUserType.NAME) {
            return new ArrayList<>(
                    companyMemberRepository
                            .findAllByMemberNameContaining(searchContent, pageable)
                            .getContent());
        } else if (searchType == AdminUserType.EMAIL) {
            return new ArrayList<>(
                    companyMemberRepository
                            .findAllByMemberEmailContaining(searchContent, pageable)
                            .getContent());
        } else {
            return new ArrayList<>(
                    companyMemberRepository
                            .findAllByMemberIdContainingOrMemberNameContainingOrMemberEmailContaining(
                                    searchContent, searchContent, searchContent, pageable)
                            .getContent());
        }
    }

    @MethodInfo(name = "count", description = "회원 수를 반환합니다.")
    public long count() {
        return companyMemberRepository.count();
    }

    @Builder
    public CompanyMemberService(CompanyMemberRepository companyMemberRepository) {
        this.companyMemberRepository = companyMemberRepository;
    }
}