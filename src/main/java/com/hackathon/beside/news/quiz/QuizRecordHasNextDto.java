package com.hackathon.beside.news.quiz;

import lombok.*;

import java.util.List;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuizRecordHasNextDto {

    private boolean hasNext;
    private List<QuizRecordDto> quizRecordDtos;

    public static QuizRecordHasNextDto toQuizRecordHasNextDto(boolean hasNext, List<QuizRecordDto> quizRecordDtos) {
        return QuizRecordHasNextDto.builder()
                .hasNext(hasNext)
                .quizRecordDtos(quizRecordDtos)
                .build();

    }
}
