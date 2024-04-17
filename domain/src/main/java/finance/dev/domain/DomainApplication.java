package finance.dev.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"finance.dev.domain"
		}
)
public class DomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);
	}

}
