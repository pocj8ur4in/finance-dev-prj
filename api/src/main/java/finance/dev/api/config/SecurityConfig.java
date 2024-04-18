package finance.dev.api.config;

import static org.springframework.security.config.Customizer.withDefaults;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@TypeInfo(name = "SecurityConfig", description = "스프링 시큐리티 설정 클래스")
@Configuration
@EnableWebSecurity // 스프링 시큐리티 설정을 활성화
public class SecurityConfig {
    @MethodInfo(name = "filterChain", description = "스프링 시큐리티 필터 체인을 설정합니다.")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // 스프링 시큐리티의 보안 필터를 조합해 HttpSecurity 반환
        httpSecurity
                // HTTP 기본 인증 비활성화
                .httpBasic(AbstractHttpConfigurer::disable)
                // CORS (Cross-Origin Resource Sharing) 설정 비활성화
                .cors(AbstractHttpConfigurer::disable)
                // CSRF (Cross-Site Request Forgery) 공격 방어 비활성화
                .csrf(AbstractHttpConfigurer::disable)
                // 세션 관리를 상태 없음 (STATELESS)으로 설정
                .sessionManagement(
                        (sessionManagement) ->
                                sessionManagement.sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        request ->
                                request.dispatcherTypeMatchers(DispatcherType.FORWARD)
                                        .permitAll() // FORWARD 요청은 인증 없이 허용
                                        .anyRequest()
                                        .permitAll() // 나머지 요청은 인증 없이 허용
                        // .requestMatchers().authenticated() // 추후 인증 필요한 영역 생기면 추가 (회원 프로필, ...)
                        )
                .formLogin( // 폼 로그인 설정
                        login ->
                                login.loginPage("/user/login") // 로그인 페이지
                                        .usernameParameter("username") // 아이디
                                        .passwordParameter("password") // 비밀번호
                                        .defaultSuccessUrl("/", true) // 회원가입 성공 시 이동할 주소
                                        .permitAll())
                .logout(withDefaults()); // 로그아웃 설정

        return httpSecurity.build(); // 구성된 HttpSecurity 객체 반환
    }

    @MethodInfo(name = "passwordEncoder", description = "비밀번호 암호화를 위한 PasswordEncoder 빈을 생성합니다.")
    @Bean
    public PasswordEncoder passwordEncoder() {
        int passwordEncoderStrength = 12; // 비밀번호 암호화 작업 비용 선택

        return new BCryptPasswordEncoder(passwordEncoderStrength); // BCrypt 알고리즘으로 비밀번호 암호화
    }
}
