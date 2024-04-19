package finance.dev.api.exception;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@TypeInfo(name = "ExceptionControllerAdvice", description = "예외 처리 컨트롤러 어드바이스 클래스")
@RestControllerAdvice(basePackages = "finance.dev.api.controller")
public class ExceptionControllerAdvice {
    @MethodInfo(name = "handleException", description = "서버에서 발생하는 전반적인 예외를 처리합니다.")
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ExceptionResponse.of(
                                HttpStatus.INTERNAL_SERVER_ERROR,
                                "서버에서 알 수 없는 예외가 발생했습니다.",
                                exception));
    }

    @MethodInfo(name = "handleBadRequestException", description = "클라이언트에서 발생하는 잘못된 요청 예외를 처리합니다.")
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(
            BadRequestException badRequestException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ExceptionResponse.of(
                                HttpStatus.BAD_REQUEST, "잘못된 요청이 전달되었습니다.", badRequestException));
    }
}
