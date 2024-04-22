import finance.dev.api.controller.member.dto.*;
import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import finance.dev.common.annotation.UseCase;
import finance.dev.domain.member.CompanyMemberEntity;
import finance.dev.domain.member.CompanyMemberService;
import finance.dev.domain.notice.CompanyNoticeEntity;
import finance.dev.domain.notice.CompanyNoticeService;
import finance.dev.domain.one2one.CompanyOne2OneEntity;
import finance.dev.domain.one2one.CompanyOne2OneService;
import finance.dev.domain.qna.CompanyQnaEntity;
import finance.dev.domain.qna.CompanyQnaService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import lombok.Builder;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;

@TypeInfo(name = "MemberUseCase", description = "회원 유스케이스 클래스")
@UseCase
public class MemberUseCase {
    private final CompanyMemberService companyMemberService;
    private final CompanyNoticeService companyNoticeService;
    private final CompanyQnaService companyQnaService;
    private final CompanyOne2OneService companyOne2OneService;

    @MethodInfo(name = "checkId", description = "아이디 중복 체크를 합니다.")
    public ResponseEntity<Void> checkId(MemberCheckIdRequest memberCheckIdRequest)
            throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (memberCheckIdRequest.getId().isEmpty()) {
                throw new BadRequestException("아이디를 입력해주세요.");
            }

            // 아이디 4~16자
            if (memberCheckIdRequest.getId().length() < 4
                    || memberCheckIdRequest.getId().length() > 16) {
                throw new BadRequestException("아이디는 4~16자로 입력해주세요.");
            }

            // 아이디 영어 소문자, 숫자만 가능
            if (!memberCheckIdRequest.getId().matches("^[a-z0-9]*$")) {
                throw new BadRequestException("아이디는 영어 소문자, 숫자만 입력해주세요.");
            }

            // 아이디 중복 체크
            if (companyMemberService.checkId(memberCheckIdRequest.getId())) {
                throw new BadRequestException("이미 사용중인 아이디입니다.");
            }

            // 아이디 중복 체크 성공
            return ResponseEntity.ok().build();

        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("아이디 중복 체크에 실패했습니다.");
        }
    }


    @Builder
    public MemberUseCase(
            CompanyMemberService companyMemberService,
            CompanyNoticeService companyNoticeService,
            CompanyQnaService companyQnaService,
            CompanyOne2OneService companyOne2OneService) {
        this.companyMemberService = companyMemberService;
        this.companyNoticeService = companyNoticeService;
        this.companyQnaService = companyQnaService;
        this.companyOne2OneService = companyOne2OneService;
    }
}
