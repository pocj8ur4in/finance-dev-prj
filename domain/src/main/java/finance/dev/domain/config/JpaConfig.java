package finance.dev.domain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "finance.dev.domain.*")
@EnableJpaAuditing // JPA 감시를 활성화
public class JpaConfig {}
