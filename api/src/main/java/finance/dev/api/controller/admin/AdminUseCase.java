package finance.dev.api.controller.admin;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import finance.dev.api.controller.admin.dto.*;
import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import finance.dev.common.annotation.UseCase;
import finance.dev.domain.admin.CompanyAdminEntity;
import finance.dev.domain.admin.CompanyAdminService;
import finance.dev.domain.member.CompanyMemberEntity;
import finance.dev.domain.member.CompanyMemberService;
import finance.dev.domain.notice.CompanyNoticeEntity;
import finance.dev.domain.notice.CompanyNoticeService;
import finance.dev.domain.one2one.CompanyOne2OneService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import lombok.Builder;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;

@TypeInfo(name = "AdminUseCase", description = "관리자 유스케이스 클래스")
@UseCase
public class AdminUseCase {
    private final CompanyAdminService companyAdminService;
    private final CompanyMemberService companyMemberService;
    private final CompanyNoticeService companyNoticeService;
    private final CompanyOne2OneService companyOne2OneService;

    @MethodInfo(name = "login", description = "관리자 로그인을 합니다.")
    public ResponseEntity<AdminLoginResponse> login(AdminLoginRequest adminLoginRequest)
            throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (adminLoginRequest.getMemberId() == null
                    || adminLoginRequest.getMemberPw() == null) {
                throw new BadRequestException("아이디와 비밀번호를 입력해주세요.");
            }

            // 로그인 : 아이디 확인
            CompanyAdminEntity companyAdminEntity =
                    companyAdminService.findMemberId(adminLoginRequest.getMemberId());
            if (companyAdminEntity == null) {
                throw new BadRequestException("아이디가 존재하지 않습니다.");
            }

            // 로그인 : 비밀번호 확인
            if (!companyAdminEntity.getMemberPw().equals(adminLoginRequest.getMemberPw())) {
                throw new BadRequestException("비밀번호가 일치하지 않습니다.");
            }

            // 로그인 성공 시 토큰 발행
            return ResponseEntity.ok(
                    AdminLoginResponse.builder()
                            .accessToken(
                                    JWT.create()
                                            .withSubject(companyAdminEntity.getMemberId())
                                            .withExpiresAt(
                                                    new Date(
                                                            System.currentTimeMillis()
                                                                    + 1000 * 60 * 60 * 24))
                                            .sign(Algorithm.HMAC512(System.getenv("JWT_SECRET"))))
                            .refreshToken(
                                    JWT.create()
                                            .withSubject(companyAdminEntity.getMemberId())
                                            .withExpiresAt(
                                                    new Date(
                                                            System.currentTimeMillis()
                                                                    + 1000 * 60 * 60 * 24 * 7))
                                            .sign(Algorithm.HMAC512(System.getenv("JWT_SECRET"))))
                            .build());
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("로그인에 실패했습니다.");
        }
    }

    @MethodInfo(name = "findUsers", description = "회원 목록을 가져옵니다.")
    public ResponseEntity<ArrayList<AdminUserResponse>> findUsers(
            AdminUsersRequest adminUsersRequest) throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (adminUsersRequest.getAccessToken() == null) {
                throw new BadRequestException("로그인이 필요합니다.");
            }

            // 토큰을 검증하고 아이디를 가져옴
            String memberId =
                    JWT.require(Algorithm.HMAC512(System.getenv("JWT_SECRET")))
                            .build()
                            .verify(adminUsersRequest.getAccessToken())
                            .getSubject();

            // 아이디 검사
            if (memberId == null) {
                throw new BadRequestException("토큰이 유효하지 않습니다.");
            }

            // 아이디가 존재하는지 체크
            if (companyAdminService.checkId(memberId)) {
                throw new BadRequestException("아이디가 존재하지 않습니다.");
            }

            // 회원 목록을 가져옴
            ArrayList<AdminUserResponse> adminUserResponses = new ArrayList<>();

            for (CompanyMemberEntity companyMemberEntity :
                    companyMemberService.searchByAdmin(
                            adminUsersRequest.getSearchType(),
                            adminUsersRequest.getSearchContent(),
                            adminUsersRequest.getSearchPageNum(),
                            adminUsersRequest.getSearchPageSize(),
                            adminUsersRequest.getSearchSort())) {
                adminUserResponses.add(
                        AdminUserResponse.builder()
                                .memberId(companyMemberEntity.getMemberId())
                                .memberName(companyMemberEntity.getMemberName())
                                .memberEmail(companyMemberEntity.getMemberEmail())
                                .memberBirthDate(companyMemberEntity.getMemberBirthDate())
                                .memberJoinDate(
                                        companyMemberEntity
                                                .getMemberJoinDate()
                                                .format(
                                                        java.time.format.DateTimeFormatter
                                                                .ofPattern("yyyy-MM-dd")))
                                .build());
            }

            return ResponseEntity.ok(adminUserResponses);
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("회원 목록을 불러오는데 실패했습니다.");
        }
    }

    @MethodInfo(name = "findUsersNumber", description = "회원 수를 가져옵니다.")
    public ResponseEntity<AdminUserNumberResponse> findUsersNumber() throws Exception {
        try {
            // 회원 수를 가져옴
            return ResponseEntity.ok(
                    AdminUserNumberResponse.builder()
                            .memberNumber((int) companyMemberService.count())
                            .build());
        } catch (Exception e) {
            throw new Exception("회원 수를 불러오는데 실패했습니다.");
        }
    }

    @MethodInfo(name = "findNoticesNumber", description = "공지사항 수를 가져옵니다.")
    public ResponseEntity<AdminNoticeNumberResponse> findNoticesNumber() throws Exception {
        try {
            // 공지사항 수를 가져옴
            return ResponseEntity.ok(
                    AdminNoticeNumberResponse.builder()
                            .noticeNumber((int) companyNoticeService.count())
                            .build());
        } catch (Exception e) {
            throw new Exception("공지사항 수를 불러오는데 실패했습니다.");
        }
    }

    @MethodInfo(name = "findNotices", description = "공지사항 목록을 가져옵니다.")
    public ResponseEntity<ArrayList<AdminNoticeResponse>> findNotices(
            AdminNoticesRequest adminNoticesRequest) throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (adminNoticesRequest.getAccessToken() == null) {
                throw new BadRequestException("로그인이 필요합니다.");
            }

            // 토큰을 검증하고 아이디를 가져옴
            String memberId =
                    JWT.require(Algorithm.HMAC512(System.getenv("JWT_SECRET")))
                            .build()
                            .verify(adminNoticesRequest.getAccessToken())
                            .getSubject();

            // 아이디 검사
            if (memberId == null) {
                throw new BadRequestException("토큰이 유효하지 않습니다.");
            }

            // 아이디가 존재하는지 체크
            if (companyAdminService.checkId(memberId)) {
                throw new BadRequestException("아이디가 존재하지 않습니다.");
            }

            // 공지사항 목록을 가져옴
            ArrayList<AdminNoticeResponse> adminNoticeResponses = new ArrayList<>();

            for (CompanyNoticeEntity companyNoticeEntity :
                    companyNoticeService.searchByAdmin(
                            adminNoticesRequest.getSearchType(),
                            adminNoticesRequest.getSearchContent(),
                            adminNoticesRequest.getSearchPageSize(),
                            adminNoticesRequest.getSearchSort(),
                            adminNoticesRequest.getSearchPageNumber())) {
                adminNoticeResponses.add(
                        AdminNoticeResponse.builder()
                                .noticeId(companyNoticeEntity.getNoticeIdx())
                                .noticeTitle(companyNoticeEntity.getNoticeTitle())
                                .noticeContent(companyNoticeEntity.getNoticeContent())
                                .noticeMemberId(companyNoticeEntity.getNoticeMemberId())
                                .noticeDate(
                                        companyNoticeEntity
                                                .getNoticeDate()
                                                .format(
                                                        java.time.format.DateTimeFormatter
                                                                .ofPattern("yyyy-MM-dd")))
                                .build());
            }

            return ResponseEntity.ok(adminNoticeResponses);
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("공지사항 목록을 불러오는데 실패했습니다.");
        }
    }

    @MethodInfo(name = "createNotice", description = "공지사항을 생성합니다.")
    public ResponseEntity<Void> createNotice(AdminNoticeCreateRequest adminNoticeCreateRequest)
            throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (adminNoticeCreateRequest.getAccessToken() == null) {
                throw new BadRequestException("로그인이 필요합니다.");
            }

            // 토큰을 검증하고 아이디를 가져옴
            String memberId =
                    JWT.require(Algorithm.HMAC512(System.getenv("JWT_SECRET")))
                            .build()
                            .verify(adminNoticeCreateRequest.getAccessToken())
                            .getSubject();

            // 아이디 검사
            if (memberId == null) {
                throw new BadRequestException("토큰이 유효하지 않습니다.");
            }

            // 아이디가 존재하는지 체크
            if (companyAdminService.checkId(memberId)) {
                throw new BadRequestException("아이디가 존재하지 않습니다.");
            }

            // 공지사항 생성
            companyNoticeService.save(
                    CompanyNoticeEntity.builder()
                            .noticeTitle(adminNoticeCreateRequest.getNoticeTitle())
                            .noticeContent(adminNoticeCreateRequest.getNoticeContent())
                            .noticeMemberId(memberId)
                            .noticeDate(LocalDateTime.now())
                            .build());

            return ResponseEntity.ok().build();
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("공지사항을 생성하는데 실패했습니다.");
        }
    }

    @MethodInfo(name = "updateNotice", description = "공지사항을 수정합니다.")
    public ResponseEntity<AdminNoticeResponse> updateNotice(
            AdminNoticeUpdateRequest adminNoticeUpdateRequest) throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (adminNoticeUpdateRequest.getAccessToken() == null) {
                throw new BadRequestException("로그인이 필요합니다.");
            }

            // 토큰을 검증하고 아이디를 가져옴
            String memberId =
                    JWT.require(Algorithm.HMAC512(System.getenv("JWT_SECRET")))
                            .build()
                            .verify(adminNoticeUpdateRequest.getAccessToken())
                            .getSubject();

            // 아이디 검사
            if (memberId == null) {
                throw new BadRequestException("토큰이 유효하지 않습니다.");
            }

            // 아이디가 존재하는지 체크
            if (companyAdminService.checkId(memberId)) {
                throw new BadRequestException("아이디가 존재하지 않습니다.");
            }

            // 공지사항 수정 대상 탐색
            CompanyNoticeEntity companyNoticeEntity =
                    companyNoticeService.findNotice(adminNoticeUpdateRequest.getNoticeId());

            // 공지사항 수정 대상이 존재하는지 체크
            if (companyNoticeEntity == null) {
                throw new BadRequestException("수정할 공지사항이 존재하지 않습니다.");
            }

            // 공지사항 수정
            companyNoticeService.save(
                    CompanyNoticeEntity.builder()
                            .noticeIdx(adminNoticeUpdateRequest.getNoticeId())
                            .noticeTitle(adminNoticeUpdateRequest.getNoticeTitle())
                            .noticeContent(adminNoticeUpdateRequest.getNoticeContent())
                            .noticeMemberId(memberId)
                            .noticeDate(companyNoticeEntity.getNoticeDate())
                            .build());

            // 공지사항 수정 검사
            if (companyNoticeService.findNotice(adminNoticeUpdateRequest.getNoticeId()) == null) {
                throw new BadRequestException("공지사항을 수정하는데 실패했습니다.");
            }

            // 공지사항 수정 결과 반환
            return ResponseEntity.ok(
                    AdminNoticeResponse.builder()
                            .noticeId(adminNoticeUpdateRequest.getNoticeId())
                            .noticeTitle(adminNoticeUpdateRequest.getNoticeTitle())
                            .noticeContent(adminNoticeUpdateRequest.getNoticeContent())
                            .noticeMemberId(memberId)
                            .build());
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("공지사항을 수정하는데 실패했습니다.");
        }
    }

    @MethodInfo(name = "findOne2ones", description = "1:1 문의 목록을 가져옵니다.")
    public ResponseEntity<ArrayList<AdminOne2oneResponse>> findOne2ones(
            AdminOne2onesRequest adminOne2onesRequest) throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (adminOne2onesRequest.getAccessToken() == null) {
                throw new BadRequestException("로그인이 필요합니다.");
            }

            // 토큰을 검증하고 아이디를 가져옴
            String memberId =
                    JWT.require(Algorithm.HMAC512(System.getenv("JWT_SECRET")))
                            .build()
                            .verify(adminOne2onesRequest.getAccessToken())
                            .getSubject();

            // 아이디 검사
            if (memberId == null) {
                throw new BadRequestException("토큰이 유효하지 않습니다.");
            }

            // 아이디가 존재하는지 체크
            if (companyAdminService.checkId(memberId)) {
                throw new BadRequestException("아이디가 존재하지 않습니다.");
            }

            // 1:1 문의 목록을 가져옴
            ArrayList<AdminOne2oneResponse> adminOne2oneResponses = new ArrayList<>();

            companyOne2OneService
                    .findAll()
                    .forEach(
                            companyOne2OneEntity ->
                                    adminOne2oneResponses.add(
                                            AdminOne2oneResponse.builder()
                                                    .one2oneId(companyOne2OneEntity.getOne2OneIdx())
                                                    .one2oneTitle(
                                                            companyOne2OneEntity.getOne2OneTitle())
                                                    .one2oneContent(
                                                            companyOne2OneEntity
                                                                    .getOne2OneContent())
                                                    .one2oneDate(
                                                            companyOne2OneEntity.getOne2OneDate())
                                                    .build()));

            return ResponseEntity.ok(adminOne2oneResponses);
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("1:1 문의 목록을 불러오는데 실패했습니다.");
        }
    }

    @Builder
    public AdminUseCase(
            CompanyAdminService companyAdminService,
            CompanyMemberService companyMemberService,
            CompanyNoticeService companyNoticeService,
            CompanyOne2OneService companyOne2OneService) {
        this.companyAdminService = companyAdminService;
        this.companyMemberService = companyMemberService;
        this.companyNoticeService = companyNoticeService;
        this.companyOne2OneService = companyOne2OneService;
    }
}
