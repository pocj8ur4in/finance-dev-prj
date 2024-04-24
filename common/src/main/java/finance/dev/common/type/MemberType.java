package finance.dev.common.type;

import lombok.Getter;

@Getter
public enum MemberType {
    NAME("제목"),
    CONTENT("내용"),
    AUTHOR("작성자");
    private final String description;

    MemberType(String description) {
        this.description = description;
    }
}
