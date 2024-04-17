package finance.dev.api.config;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TypeInfo(name = "SwaggerConfig", description = "Swagger 설정 클래스")
@Configuration
@OpenAPIDefinition(
        info =
                @Info(
                        title = "디지털하나로 프로젝트 API",
                        version = "v1",
                        description = "디지털하나로 프로젝트에서 제공하는 API 목록입니다.",
                        license =
                                @io.swagger.v3.oas.annotations.info.License(
                                        name = "Apache 2.0",
                                        url = "http://www.apache.org/licenses/LICENSE-2.0.html")))
public class SwaggerConfig {
    @MethodInfo(name = "groupedOpenApi", description = "그룹화된 OpenAPI 스펙을 담은 객체를 반환합니다.")
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        String[] paths = {"/**"}; // Swagger 경로 지정

        // GroupedOpenApi : 그룹화된 OpenAPI 스펙을 담은 객체
        return GroupedOpenApi.builder().group("finance-dev-prj").pathsToMatch(paths).build();
    }
}
