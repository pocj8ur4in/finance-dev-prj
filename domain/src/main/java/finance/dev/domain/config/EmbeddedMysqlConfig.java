package finance.dev.domain.config;

import static com.wix.mysql.config.Charset.UTF8;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.ScriptResolver;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.distribution.Version;
import java.time.ZoneId;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedMysqlConfig {
    public EmbeddedMysqlConfig() {
        // 임배디드 MySQL 설정
        MysqldConfig mysqldConfig =
                MysqldConfig.aMysqldConfig(Version.v8_latest)
                        .withCharset(UTF8)
                        .withPort(
                                System.getenv("MYSQL_PORT") != null
                                        ? Integer.parseInt(System.getenv("MYSQL_PORT"))
                                        : 3306)
                        .withTimeout(2, TimeUnit.MINUTES)
                        .withUser(System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASSWORD"))
                        .withTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()))
                        .withServerVariable("max_connect_errors", 666)
                        .build();

        // 임배디드 MySQL 서버 시작
        EmbeddedMysql embeddedMysql =
                EmbeddedMysql.anEmbeddedMysql(mysqldConfig)
                        .addSchema(
                                System.getenv("MYSQL_DATABASE"),
                                ScriptResolver.classPathScript("init.sql"))
                        .start();

        // 임배디드 MySQL 데이터소스 설정
        System.setProperty(
                "spring.datasource.driver-class-name",
                "com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 클래스 설정
        System.setProperty(
                "spring.datasource.url",
                "jdbc:mysql://"
                        + System.getenv("MYSQL_HOST")
                        + ":"
                        + System.getenv("MYSQL_PORT")
                        + "/"
                        + System.getenv("MYSQL_DATABASE")
                        + "?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"); // MySQL
        // URL
        // 설정
        System.setProperty(
                "spring.datasource.username", System.getenv("MYSQL_USER")); // MySQL 사용자 설정
        System.setProperty(
                "spring.datasource.password", System.getenv("MYSQL_PASSWORD")); // MySQL 비밀번호 설정
    }
}
