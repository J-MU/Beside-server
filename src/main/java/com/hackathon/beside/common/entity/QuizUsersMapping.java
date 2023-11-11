package com.hackathon.beside.common.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class QuizUsersMapping {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private int correctCount;
    private int wrongCount;
}
