package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCheckIdRequest {
    private final String id;

    @Builder
    public MemberCheckIdRequest(String id) {
        this.id = id;
    }
}
