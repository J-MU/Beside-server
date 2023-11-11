package com.hackathon.beside.common.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
public class Quiz {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;
    @OneToMany(mappedBy = "quiz")
    private List<QuizUsersMapping> quizUsersMappings;
}
