package finance.dev.api.controller.admin;

import finance.dev.api.controller.admin.dto.*;
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

@TypeInfo(name = "AdminRestController", description = "회사 관리자 컨트롤러 클래스")
@Tag(name = "AdminRestController", description = "회사 관리자 컨트롤러입니다.")
@RequestMapping("v1/api/admin")
@RestController
public class AdminRestController {
    private final AdminUseCase adminUseCase;

    @MethodInfo(name = "adminLogin", description = "관리자 로그인를 합니다.")
    @GetMapping("/login")
    @Operation(
            summary = "관리자 로그인",
            description = "관리자 로그인을 합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "관리자 로그인 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                AdminLoginResponse.class))),
                @ApiResponse(responseCode = "400", description = "관리자 로그인 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<AdminLoginResponse> adminLogin(
            @RequestBody AdminLoginRequest adminLoginRequest) throws Exception {
        return adminUseCase.login(adminLoginRequest);
    }

    @MethodInfo(name = "adminUsers", description = "관리자 회원 목록을 조회합니다.")
    @GetMapping("/users")
    @Operation(
            summary = "관리자 회원 목록 조회",
            description = "관리자 회원 목록을 조회합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "관리자 회원 목록 조회 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(implementation = AdminUserResponse.class))),
                @ApiResponse(responseCode = "400", description = "관리자 회원 목록 조회 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<ArrayList<AdminUserResponse>> adminUsers(
            @RequestBody AdminUsersRequest adminUsersRequest) throws Exception {
        return adminUseCase.findUsers(adminUsersRequest);
    }

    @MethodInfo(name = "adminUsersNumber", description = "관리자 회원 개수를 조회합니다.")
    @GetMapping("/users/number")
    @Operation(
            summary = "관리자 회원 개수 조회",
            description = "관리자 회원 개수를 조회합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "관리자 회원 개수 조회 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                AdminUserNumberResponse.class))),
                @ApiResponse(responseCode = "400", description = "관리자 회원 개수 조회 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<AdminUserNumberResponse> adminUsersNumber() throws Exception {
        return adminUseCase.findUsersNumber();
    }

    @MethodInfo(name = "adminNotices", description = "관리자 공지사항 목록을 조회합니다.")
    @GetMapping("/notices")
    @Operation(
            summary = "관리자 공지사항 목록 조회",
            description = "관리자 공지사항 목록을 조회합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "관리자 공지사항 목록 조회 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                AdminNoticeResponse.class))),
                @ApiResponse(responseCode = "400", description = "관리자 공지사항 목록 조회 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<ArrayList<AdminNoticeResponse>> adminNotices(
            @RequestBody AdminNoticesRequest adminNoticesRequest) throws Exception {
        return adminUseCase.findNotices(adminNoticesRequest);
    }

    @MethodInfo(name = "adminNoticesNumber", description = "관리자 공지사항 개수를 조회합니다.")
    @GetMapping("/notices/number")
    @Operation(
            summary = "관리자 공지사항 개수 조회",
            description = "관리자 공지사항 개수를 조회합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "관리자 공지사항 개수 조회 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                AdminNoticeNumberResponse.class))),
                @ApiResponse(responseCode = "400", description = "관리자 공지사항 개수 조회 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<AdminNoticeNumberResponse> adminNoticesNumber() throws Exception {
        return adminUseCase.findNoticesNumber();
    }

    @MethodInfo(name = "createAdminNotice", description = "관리자 공지사항을 등록합니다.")
    @GetMapping("/notice")
    @Operation(
            summary = "관리자 공지사항 등록",
            description = "관리자 공지사항을 등록합니다.",
            method = "GET",
            responses = {
                @ApiResponse(responseCode = "200", description = "관리자 공지사항 등록 성공"),
                @ApiResponse(responseCode = "400", description = "관리자 공지사항 등록 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<Void> createAdminNotice(
            @RequestBody AdminNoticeCreateRequest adminNoticeCreateRequest) throws Exception {
        return adminUseCase.createNotice(adminNoticeCreateRequest);
    }

    @MethodInfo(name = "updateAdminNotice", description = "관리자 공지사항을 수정합니다.")
    @GetMapping("/notice/update")
    @Operation(
            summary = "관리자 공지사항 수정",
            description = "관리자 공지사항을 수정합니다.",
            method = "GET",
            responses = {
                @ApiResponse(responseCode = "200", description = "관리자 공지사항 수정 성공"),
                @ApiResponse(responseCode = "400", description = "관리자 공지사항 수정 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<AdminNoticeResponse> updateAdminNotice(
            @RequestBody AdminNoticeUpdateRequest adminNoticeUpdateRequest) throws Exception {
        return adminUseCase.updateNotice(adminNoticeUpdateRequest);
    }

    @MethodInfo(name = "deleteAdminNotice", description = "관리자 일대일문의를 조회합니다.")
    @GetMapping("/one2ones")
    @Operation(
            summary = "관리자 일대일문의 목록 조회",
            description = "관리자 일대일문의 목록을 조회합니다.",
            method = "GET",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "관리자 일대일문의 목록 조회 성공",
                        content =
                                @Content(
                                        schema =
                                                @Schema(
                                                        implementation =
                                                                AdminOne2oneResponse.class))),
                @ApiResponse(responseCode = "400", description = "관리자 일대일문의 목록 조회 실패"),
                @ApiResponse(responseCode = "500", description = "서버 에러")
            })
    public ResponseEntity<ArrayList<AdminOne2oneResponse>> adminOne2ones(
            @RequestBody AdminOne2onesRequest adminOne2onesRequest) throws Exception {
        return adminUseCase.findOne2ones(adminOne2onesRequest);
    }

    public AdminRestController(AdminUseCase adminUseCase) {
        this.adminUseCase = adminUseCase;
    }
}
