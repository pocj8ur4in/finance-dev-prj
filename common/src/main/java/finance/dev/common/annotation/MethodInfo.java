package finance.dev.common.annotation;

import java.lang.annotation.*;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@TypeInfo(name = "MethodInfo", description = "메소드 정보를 제공하는 어노테이션 인터페이스")
@Target({ElementType.METHOD}) // 어노테이션을 사용할 수 있는 대상을 메소드로 지정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 정보를 런타임 시간까지 유지하도록 설정
@Documented // 해당 어노테이션을 javadoc에 포함시킴
@Component
public @interface MethodInfo {
    @AliasFor(annotation = Component.class)
    String value() default ""; // 해당 어노테이션을 스프링 컨테이너의 빈으로 등록할 때 사용할 이름

    String name(); // 메소드 이름

    String description(); // 메소드 설명
}
