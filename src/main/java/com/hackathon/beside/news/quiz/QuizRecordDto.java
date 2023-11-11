package com.hackathon.beside.news.quiz;

import com.hackathon.beside.common.entity.Quiz;
import com.hackathon.beside.common.entity.QuizUsersMapping;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuizRecordDto {

    private Long quizId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String subject;
    private int correctCount;
    private int wrongCount;
    private float answerLate;

    public static QuizRecordDto toQuizRecordDto(Quiz quiz, QuizUsersMapping quizUsersMapping) {
        return QuizRecordDto.builder()
                .quizId(quiz.getId())
                .startDate(quiz.getStartDate())
                .endDate(quiz.getEndDate())
                .correctCount(quizUsersMapping.getCorrectCount())
                .wrongCount(quizUsersMapping.getWrongCount())
                .answerLate(
                        Math.round(quizUsersMapping.getCorrectCount() / (quizUsersMapping.getCorrectCount() + quizUsersMapping.getWrongCount()) * 100) * 100.0f / 100.0f
                )
                .build();
    }
}
