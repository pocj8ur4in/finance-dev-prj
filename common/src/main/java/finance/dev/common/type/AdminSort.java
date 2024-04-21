package finance.dev.common.type;

import lombok.Getter;

@Getter
public enum AdminSort {
    ID_DESC("아이디 내림차순"),
    ID_ASC("아이디 오름차순"),
    JOIN_DATE_DESC("가입일 내림차순"),
    JOIN_DATE_ASC("가입일 오름차순");
    private final String description;

    AdminSort(String description) {
        this.description = description;
    }
}
