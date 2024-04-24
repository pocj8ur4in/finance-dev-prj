package finance.dev.api.controller.member;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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

    @MethodInfo(name = "join", description = "회원가입을 합니다.")
    public ResponseEntity<Void> join(MemberJoinRequest memberJoinRequest) throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (memberJoinRequest.getMemberId().isEmpty()
                    || memberJoinRequest.getMemberPw().isEmpty()
                    || memberJoinRequest.getMemberPwConfirm().isEmpty()) {
                throw new BadRequestException("모든 항목을 입력해주세요.");
            }

            // 아이디 4~16자
            if (memberJoinRequest.getMemberId().length() < 4
                    || memberJoinRequest.getMemberId().length() > 16) {
                throw new BadRequestException("아이디는 4~16자로 입력해주세요.");
            }

            // 아이디 영어 소문자, 숫자만 가능
            if (!memberJoinRequest.getMemberId().matches("^[a-z0-9]*$")) {
                throw new BadRequestException("아이디는 영어 소문자, 숫자만 입력해주세요.");
            }

            // 아이디 중복 체크
            if (companyMemberService.checkId(memberJoinRequest.getMemberId())) {
                throw new BadRequestException("이미 사용중인 아이디입니다.");
            }

            // 비밀번호 8~16자
            if (memberJoinRequest.getMemberPw().length() < 8
                    || memberJoinRequest.getMemberPw().length() > 16) {
                throw new BadRequestException("비밀번호는 8~16자로 입력해주세요.");
            }

            // 비밀번호 영어, 특수문자, 숫자만 가능
            if (!memberJoinRequest.getMemberPw().matches("^[a-zA-Z0-9!@#$%^&*]*$")) {
                throw new BadRequestException("비밀번호는 영어, 특수문자, 숫자만 입력해주세요.");
            }

            // 비밀번호 첫글자는 영어
            if (!Character.isLetter(memberJoinRequest.getMemberPw().charAt(0))) {
                throw new BadRequestException("비밀번호 첫글자는 영어로 입력해주세요.");
            }

            // 비밀번호와 비밀번호 확인 일치
            if (!memberJoinRequest.getMemberPw().equals(memberJoinRequest.getMemberPwConfirm())) {
                throw new BadRequestException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            }

            // 회원가입
            companyMemberService.join(
                    CompanyMemberEntity.builder()
                            .memberId(memberJoinRequest.getMemberId())
                            .memberPw(memberJoinRequest.getMemberPw())
                            .memberEmail(memberJoinRequest.getMemberEmail())
                            .memberBirthDate(memberJoinRequest.getMemberBirthDate())
                            .memberJoinDate(LocalDateTime.now())
                            .memberEmailReceive(memberJoinRequest.getMemberEmailReceive())
                            .memberName(memberJoinRequest.getMemberName())
                            .memberGender(memberJoinRequest.getMemberGender())
                            .memberPwQuestion(memberJoinRequest.getMemberPwQuestion())
                            .memberPwAnswer(memberJoinRequest.getMemberPwAnswer())
                            .build());

            // 회원가입 검사
            if (!companyMemberService.checkId(memberJoinRequest.getMemberId())) {
                throw new BadRequestException("회원가입에 실패했습니다.");
            }

            // 회원가입 성공
            return ResponseEntity.ok().build();

        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("회원가입에 실패했습니다.");
        }
    }

    @MethodInfo(name = "login", description = "로그인을 합니다.")
    public ResponseEntity<MemberLoginResponse> login(MemberLoginRequest memberLoginRequest)
            throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (memberLoginRequest.getMemberId().isEmpty()
                    || memberLoginRequest.getMemberPw().isEmpty()) {
                throw new BadRequestException("아이디 또는 비밀번호를 입력해주세요.");
            }

            // 로그인
            CompanyMemberEntity companyMemberEntity =
                    companyMemberService.login(memberLoginRequest.getMemberId());

            // 로그인 검사
            if (companyMemberEntity == null) {
                throw new BadRequestException("일치하는 아이디가 없습니다.");
            }

            if (!companyMemberEntity.getMemberPw().equals(memberLoginRequest.getMemberPw())) {
                throw new BadRequestException("비밀번호가 일치하지 않습니다.");
            }

            // 로그인 성공 시 토큰 발행
            return ResponseEntity.ok(
                    MemberLoginResponse.builder()
                            .accessToken(
                                    JWT.create()
                                            .withSubject(companyMemberEntity.getMemberId())
                                            .withExpiresAt(
                                                    new Date(
                                                            System.currentTimeMillis()
                                                                    + 1000 * 60 * 60 * 24))
                                            .sign(Algorithm.HMAC512(System.getenv("JWT_SECRET"))))
                            .refreshToken(
                                    JWT.create()
                                            .withSubject(companyMemberEntity.getMemberId())
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

    @MethodInfo(name = "findId", description = "아이디 찾기를 합니다.")
    public ResponseEntity<MemberFindIdResponse> findId(MemberFindIdRequest memberFindIdRequest)
            throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (memberFindIdRequest.getMemberName().isEmpty()
                    || memberFindIdRequest.getMemberEmail().isEmpty()) {
                throw new BadRequestException("이름과 이메일을 입력해주세요.");
            }

            // 아이디 찾기
            CompanyMemberEntity companyMemberEntity =
                    companyMemberService.findByMemberNameAndMemberEmail(
                            memberFindIdRequest.getMemberName(),
                            memberFindIdRequest.getMemberEmail());

            // 아이디 찾기 검사
            if (companyMemberEntity == null) {
                throw new BadRequestException("일치하는 아이디가 없습니다.");
            }

            // 아이디 찾기 성공
            return ResponseEntity.ok(
                    MemberFindIdResponse.builder()
                            .memberId(companyMemberEntity.getMemberId())
                            .build());

        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("아이디 찾기에 실패했습니다.");
        }
    }

    @MethodInfo(name = "findPw", description = "비밀번호 찾기를 합니다.")
    public ResponseEntity<MemberFindPwResponse> findPw(MemberFindPwRequest memberFindPwRequest)
            throws Exception {
        try {
            // 값이 비어있지 않은지 체크
            if (memberFindPwRequest.getMemberId().isEmpty()
                    || memberFindPwRequest.getMemberName().isEmpty()
                    || memberFindPwRequest.getMemberEmail().isEmpty()) {
                throw new BadRequestException("아이디, 이름, 이메일을 입력해주세요.");
            }

            // 비밀번호 찾기
            String memberPw =
                    companyMemberService.findPw(
                            memberFindPwRequest.getMemberId(),
                            memberFindPwRequest.getMemberName(),
                            memberFindPwRequest.getMemberEmail());

            // 비밀번호 찾기 검사
            if (memberPw == null) {
                throw new BadRequestException("일치하는 비밀번호가 없습니다.");
            }

            // 비밀번호 찾기 성공
            return ResponseEntity.ok(MemberFindPwResponse.builder().memberPw(memberPw).build());

        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("비밀번호 찾기에 실패했습니다.");
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
