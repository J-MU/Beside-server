package com.hackathon.beside.news.quiz;

import com.hackathon.beside.common.entity.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("select quiz from Quiz quiz join quiz.quizUsersMappings qum where qum.user.id =:id")
    Page<Quiz> findAllQuizRecord(@Param("id") Long id, PageRequest pageRequest);

    @Query("select quiz from Quiz quiz order by quiz.id desc limit 1")
    Optional<Quiz> getTodayQuiz();
}
