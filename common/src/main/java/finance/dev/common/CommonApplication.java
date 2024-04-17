package finance.dev.common;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@TypeInfo(name = "CommonApplication", description = "Common 모듈 메인 클래스")
@SpringBootApplication(
        scanBasePackages = {"finance.dev.common",})
public class CommonApplication {
    @MethodInfo(name = "main", description = "Common 모듈을 실행합니다.")
    public static void main(String[] args) {
        String activeProfile = System.getenv("SPRING_PROFILES_ACTIVE");
        SpringApplication springApplication = new SpringApplication(CommonApplication.class);
        springApplication.setAdditionalProfiles(activeProfile);
        springApplication.run(args);
    }
}
