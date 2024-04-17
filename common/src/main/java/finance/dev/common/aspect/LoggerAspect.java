package finance.dev.common.aspect;

import finance.dev.common.annotation.MethodInfo;
import finance.dev.common.annotation.TypeInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@TypeInfo(name = "LoggerAspect", description = "로그 출력 Aspect 클래스")
@Component
@Aspect // Aspect 정의
public class LoggerAspect {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoggerAspect.class); // Logger 객체 생성

    @MethodInfo(name = "logMethodInfo", description = "메소드 정보를 로그로 출력합니다.")
    @Before("@annotation(methodInfo)") // 메소드에 @MethodInfo 어노테이션이 붙어있는 경우 해당 메소드 실행 전에 아래 메소드 실행
    public void logMethodInfo(JoinPoint joinPoint, MethodInfo methodInfo) {
        LOGGER.info(
                "'{}' 클래스의 '{}' 메소드가 실행됩니다. {}",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                methodInfo.description());
    }
}
