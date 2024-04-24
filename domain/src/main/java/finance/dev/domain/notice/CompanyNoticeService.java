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

    @MethodInfo(name = "searchByMember", description = "회원 조건에 맞게 공지사항을 검색합니다.")
    public ArrayList<CompanyNoticeEntity> searchByMember(
            MemberType searchType, String searchContent) {
        if (searchType == MemberType.NAME) {
            return new ArrayList<>(
                    companyNoticeRepository.findAllByNoticeTitleContaining(
                            Pageable.unpaged(), searchContent));
        } else if (searchType == MemberType.CONTENT) {
            return new ArrayList<>(
                    companyNoticeRepository.findAllByNoticeContentContaining(
                            Pageable.unpaged(), searchContent));
        } else if (searchType == MemberType.AUTHOR) {
            return new ArrayList<>(
                    companyNoticeRepository.findAllByNoticeMemberIdContaining(
                            Pageable.unpaged(), searchContent));
        } else {
            return new ArrayList<>(
                    companyNoticeRepository
                            .findAllByNoticeTitleContainingOrNoticeContentContainingOrNoticeMemberIdContaining(
                                    Pageable.unpaged(),
                                    searchContent,
                                    searchContent,
                                    searchContent));
        }
    }

    @MethodInfo(name = "searchByAdmin", description = "관리자 조건에 맞게 공지사항을 검색합니다.")
    public ArrayList<CompanyNoticeEntity> searchByAdmin(
            AdminNoticeType searchType,
            String searchContent,
            AdminPageSize pageSize,
            AdminSort searchSort,
            int searchPageNum) {
        String query =
                "SELECT n.* FROM testdb.company_notice AS n INNER JOIN testdb.company_member_admin AS m ON n.notice_member_id = m.member_id";

        if (searchType == AdminNoticeType.ENTIRE) {
            query +=
                    " WHERE n.notice_title LIKE '%"
                            + searchContent
                            + "%' OR n.notice_content LIKE '%"
                            + searchContent
                            + "%' OR n.notice_member_id LIKE '%"
                            + searchContent
                            + "%'";
        } else if (searchType == AdminNoticeType.NAME) {
            query += " WHERE n.notice_title LIKE '%" + searchContent + "%'";
        } else if (searchType == AdminNoticeType.CONTENT) {
            query += " WHERE n.notice_content LIKE '%" + searchContent + "%'";
        } else if (searchType == AdminNoticeType.ID) {
            query += " WHERE n.notice_member_id LIKE '%" + searchContent + "%'";
        }

        if (searchSort == AdminSort.ID_DESC) {
            query += " ORDER BY n.notice_idx DESC";
        } else if (searchSort == AdminSort.ID_ASC) {
            query += " ORDER BY n.notice_idx ASC";
        } else if (searchSort == AdminSort.JOIN_DATE_DESC) {
            query += " ORDER BY m.member_join_date DESC";
        } else if (searchSort == AdminSort.JOIN_DATE_ASC) {
            query += " ORDER BY m.member_join_date ASC";
        }

        if (pageSize == AdminPageSize.SIZE_5) {
            query += " LIMIT " + 5 + " OFFSET " + searchPageNum * 5;
        } else if (pageSize == AdminPageSize.SIZE_10) {
            query += " LIMIT " + 10 + " OFFSET " + searchPageNum * 10;
        } else if (pageSize == AdminPageSize.SIZE_ENTIRE) {
            query += " LIMIT " + 20 + " OFFSET " + searchPageNum * 20;
        }

        return new ArrayList<>(
                entityManager.createNativeQuery(query, CompanyNoticeEntity.class).getResultList());
    }
    @MethodInfo(name = "count", description = "공지사항의 개수를 조회합니다.")
    public long count() {
        return companyNoticeRepository.count();
    }
    @Builder
    public CompanyNoticeService(
            CompanyNoticeRepository companyNoticeRepository, EntityManager entityManager) {
        this.companyNoticeRepository = companyNoticeRepository;
        this.entityManager = entityManager;
    }
}
