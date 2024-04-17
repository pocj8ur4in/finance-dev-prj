package finance.dev.api;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@TypeInfo(name = "ApiApplicationTests", description = "API 모듈 테스트 클래스")
@SpringBootTest
class ApiApplicationTests {
    @MethodInfo(name = "contextLoads", description = "API 모듈이 로드되는지 테스트합니다.")
    @Test
    void contextLoads() {}
}
