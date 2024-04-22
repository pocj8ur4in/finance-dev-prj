package finance.dev.common.type;

import lombok.Getter;

@Getter
public enum AdminNoticeType {
    ENTIRE("전체"),
    NAME("이름"),
    CONTENT("내용"),
    ID("아이디");
    private final String description;

    AdminNoticeType(String description) {
        this.description = description;
    }
}
