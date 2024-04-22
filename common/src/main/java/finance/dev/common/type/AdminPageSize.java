package finance.dev.common.type;

import lombok.Getter;

@Getter
public enum AdminPageSize {
    SIZE_5("5개씩 보기"),
    SIZE_10("10개씩 보기"),
    SIZE_ENTIRE("전체 보기");

    private final String description;

    AdminPageSize(String description) {
        this.description = description;
    }
}
