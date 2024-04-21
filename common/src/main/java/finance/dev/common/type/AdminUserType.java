package finance.dev.common.type;

import lombok.Getter;

@Getter
public enum AdminUserType {
    ENTIRE("전체"),
    ID("아이디"),
    NAME("이름"),
    EMAIL("이메일");
    private final String description;

    AdminUserType(String description) {
        this.description = description;
    }
}
