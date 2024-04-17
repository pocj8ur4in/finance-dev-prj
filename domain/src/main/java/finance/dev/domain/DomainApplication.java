package finance.dev.domain;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@TypeInfo(name = "DomainApplication", description = "Domain 모듈 메인 클래스")
@SpringBootApplication(
        scanBasePackages = {
            "finance.dev.domain",
            "finance.dev.common",
        })
public class DomainApplication {
    @MethodInfo(name = "main", description = "Domain 모듈을 실행합니다.")
    public static void main(String[] args) {
        SpringApplication.run(DomainApplication.class, args);
    }
}
