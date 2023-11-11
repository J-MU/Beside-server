package com.hackathon.beside.common.quizUsersMapping;

import com.hackathon.beside.common.entity.QuizUsersMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizUsersMappingRepository extends JpaRepository<QuizUsersMapping, Long> {

}
