package finance.dev.api.controller.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberQnaResponse {
    private final int qnaId;
    private final String qnaName;
    private final String qnaTitle;
    private final String qnaDate;
    private final String qnaContent;
    private final String qnaPw;

    @Builder
    public MemberQnaResponse(
            int qnaId,
            String qnaName,
            String qnaTitle,
            String qnaDate,
            String qnaContent,
            String qnaPw) {
        this.qnaId = qnaId;
        this.qnaName = qnaName;
        this.qnaTitle = qnaTitle;
        this.qnaDate = qnaDate;
        this.qnaContent = qnaContent;
        this.qnaPw = qnaPw;
    }
}
