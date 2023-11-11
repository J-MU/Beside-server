package com.hackathon.beside.news.quiz;

import com.hackathon.beside.common.entity.User;
import com.hackathon.beside.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/record/quiz")
    public QuizRecordHasNextDto quizRecord(
            @RequestParam("userId") Long userId,
            @PageableDefault(page = 0) Pageable pageable
    ) {
        QuizRecordHasNextDto quizRecordHasNextDto = quizService.quizRecord(userId, pageable);

        return quizRecordHasNextDto;
    }
}
