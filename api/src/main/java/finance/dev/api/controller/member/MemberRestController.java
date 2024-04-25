package finance.dev.api.controller.member;

import finance.dev.api.controller.member.dto.*;
import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@TypeInfo(name = "MemberRestController", description = "회사 회원 컨트롤러 클래스")
@Tag(name = "MemberRestController", description = "회사 회원 컨트롤러입니다.")
@RequestMapping("v1/api/member")
@RestController
public class MemberRestController {
    private final MemberUseCase memberUseCase;

    @MethodInfo(name = "memberCheckId", description = "회원 아이디 중복 체크를 합니다.")
    @GetMapping("/idChk")
    @Operation(
            summary = "회원 아이디 중복 체크",
            description = "회원 아이디 중복 체크를 합니다.",
            method = "GET",
            responses = {
                @ApiResponse(responseCode = "200", description = "회원 아이디 중복 체크 성공"),
                @ApiResponse(responseCode = "400", description = "회원 아이디 중복 체크 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<Void> memberCheckId(
            @RequestBody MemberCheckIdRequest memberCheckIdRequest) throws Exception {
        return memberUseCase.checkId(memberCheckIdRequest);
    }

    @MethodInfo(name = "memberJoin", description = "회원 가입을 합니다.")
    @GetMapping("/join")
    @Operation(
            summary = "회원 가입",
            description = "회원 가입을 합니다.",
            method = "GET",
            responses = {
                @ApiResponse(responseCode = "200", description = "회원 가입 성공"),
                @ApiResponse(responseCode = "400", description = "회원 가입 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<Void> memberJoin(@RequestBody MemberJoinRequest memberJoinRequest)
            throws Exception {
        return memberUseCase.join(memberJoinRequest);
    }

    @MethodInfo(name = "memberLogin", description = "회원 로그인를 합니다.")
    @GetMapping("/login")
    @Operation(
            summary = "회원 로그인",
            description = "회원 로그인을 합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "회원 로그인 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                MemberLoginResponse.class))),
                @ApiResponse(responseCode = "400", description = "회원 로그인 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<MemberLoginResponse> memberLogin(
            @RequestBody MemberLoginRequest memberLoginRequest) throws Exception {
        return memberUseCase.login(memberLoginRequest);
    }

    @MethodInfo(name = "memberLogout", description = "회원 아이디 찾기를 합니다.")
    @GetMapping("/id")
    @Operation(
            summary = "회원 아이디 찾기",
            description = "회원 아이디 찾기를 합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "회원 아이디 찾기 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                MemberFindIdResponse.class))),
                @ApiResponse(responseCode = "400", description = "회원 아이디 찾기 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<MemberFindIdResponse> memberFindId(
            @RequestBody MemberFindIdRequest memberFindIdRequest) throws Exception {
        return memberUseCase.findId(memberFindIdRequest);
    }

    @MethodInfo(name = "memberPw", description = "회원 비밀번호 찾기를 합니다.")
    @GetMapping("/pw")
    @Operation(
            summary = "회원 비밀번호 찾기",
            description = "회원 비밀번호 찾기를 합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "회원 비밀번호 찾기 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                MemberFindPwResponse.class))),
                @ApiResponse(responseCode = "400", description = "회원 비밀번호 찾기 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<MemberFindPwResponse> memberFindPw(
            @RequestBody MemberFindPwRequest memberFindPwRequest) throws Exception {
        return memberUseCase.findPw(memberFindPwRequest);
    }

    @MethodInfo(name = "memberPwChange", description = "회원 비밀번호 변경을 합니다.")
    @GetMapping("/notices")
    @Operation(
            summary = "회원 공지사항 목록 조회",
            description = "회원 공지사항 목록을 조회합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "회원 공지사항 목록 조회 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                MemberNoticeResponse.class))),
                @ApiResponse(responseCode = "400", description = "회원 공지사항 목록 조회 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<ArrayList<MemberNoticeResponse>> memberNotices(
            @RequestBody MemberNoticesRequest memberNoticesRequest) throws Exception {
        return memberUseCase.findNotices(memberNoticesRequest);
    }

    @MethodInfo(name = "memberNotice", description = "회원 공지사항 상세 조회를 합니다.")
    @GetMapping("/notice")
    @Operation(
            summary = "회원 공지사항 상세 조회",
            description = "회원 공지사항 상세를 조회합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "회원 공지사항 상세 조회 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                MemberNoticeResponse.class))),
                @ApiResponse(responseCode = "400", description = "회원 공지사항 상세 조회 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<MemberNoticeResponse> memberNotice(
            @RequestBody MemberNoticeRequest memberNoticeRequest) throws Exception {
        return memberUseCase.findNotice(memberNoticeRequest);
    }

    @MethodInfo(name = "memberOne2one", description = "회원 일대일문의 등록을 합니다.")
    @GetMapping("/one2one")
    @Operation(
            summary = "회원 일대일문의 등록",
            description = "회원 일대일문의를 등록합니다.",
            method = "GET",
            responses = {
                @ApiResponse(responseCode = "200", description = "회원 일대일문의 등록 성공"),
                @ApiResponse(responseCode = "400", description = "회원 일대일문의 등록 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<Void> memberOne2one(
            @RequestBody MemberOne2oneRequest memberOne2oneRequest) throws Exception {
        return memberUseCase.one2one(memberOne2oneRequest);
    }


    public MemberRestController(MemberUseCase memberUseCase) {
        this.memberUseCase = memberUseCase;
    }
}
