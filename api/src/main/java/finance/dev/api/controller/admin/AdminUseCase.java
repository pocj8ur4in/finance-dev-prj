
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
