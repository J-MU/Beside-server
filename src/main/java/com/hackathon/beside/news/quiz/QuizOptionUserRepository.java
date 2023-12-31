package com.hackathon.beside.news.quiz;

import com.hackathon.beside.common.entity.QuizOptionUserMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface QuizOptionUserRepository extends JpaRepository<QuizOptionUserMapping, Long> {

    @Query("select qoum from QuizOptionUserMapping qoum where qoum.user.id =:userId and qoum.quizOption.question.id =:questionId")
    QuizOptionUserMapping findByUserIdAndQuestionId(@Param("userId") Long userId, @Param("questionId") Long questionId);

    @Query("select qoum from QuizOptionUserMapping qoum where qoum.user.id =:userId and qoum.quizOption.question.id in (:questionIds)")
    List<QuizOptionUserMapping> findByUserChoices(@Param("userId") Long userId, @Param("questionIds") List<Long> questionIds);
}
