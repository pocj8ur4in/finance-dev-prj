package finance.dev.common;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@TypeInfo(name = "CommonApplication", description = "Common 모듈의 메인 클래스")
@SpringBootApplication
public class CommonApplication {
    @MethodInfo(name = "main", description = "Common 모듈을 실행합니다.")
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }
}
