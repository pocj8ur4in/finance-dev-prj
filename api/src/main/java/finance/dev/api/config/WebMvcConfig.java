package finance.dev.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer { // 웹 어플리케이션에서 정적 리소스 관리
    @Override
    public void addResourceHandlers(
            ResourceHandlerRegistry resourceHandlerRegistry) { // 정적 리소스의 요청 경로와 실제 파일 시스템 경로 매핑
        resourceHandlerRegistry
                .addResourceHandler("/static/**") // 해당 URL 패턴에 대한 정적 리소스 핸들러 등록
                .addResourceLocations("classpath:/static/"); // 해당 디렉토리에 있는 정적 리소스를 연결하도록 설정

        resourceHandlerRegistry
                .addResourceHandler("/templates/**") // "/templates/" 경로에 대한 요청을 처리
                .addResourceLocations("classpath:/templates/"); // 클래스패스의 "/templates/" 디렉토리에 있는 템플릿 제공
    }
}
