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


    public MemberRestController(MemberUseCase memberUseCase) {
        this.memberUseCase = memberUseCase;
    }
}
