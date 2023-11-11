package com.hackathon.beside.news.quiz;

import com.hackathon.beside.common.entity.Quiz;
import com.hackathon.beside.common.entity.QuizUsersMapping;
import com.hackathon.beside.common.entity.User;
import com.hackathon.beside.common.quizUsersMapping.QuizUsersMappingRepository;
import com.hackathon.beside.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizUsersMappingRepository quizUsersMappingRepository;
    private final UserRepository userRepository;

    public QuizRecordHasNextDto quizRecord(Long userId, Pageable pageable) {
        int page = pageable.getPageNumber(); // page 위치에 있는 값은 0부터 시작한다.
        int pageLimit = 20; // 한페이지에 보여줄 글 개수

        User user = userRepository.findById(userId).orElseThrow();

        PageRequest pageRequest = PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id"));
        Page<Quiz> pageQuiz = quizRepository.findAllQuizRecord(pageRequest,user.getId());

        boolean hasNext = pageQuiz.hasNext();

        // 한 페이지당 3개식 글을 보여주고 정렬 기준은 ID기준으로 내림차순
        List<QuizUsersMapping> quizUsersMappings = quizUsersMappingRepository.findAll();
        List<QuizRecordDto> quizRecordDtos = new ArrayList<>();

        for (QuizUsersMapping quizUsersMapping : quizUsersMappings) {
            if (isEqualUser(user, quizUsersMapping)) {
                quizRecordDtos.add(QuizRecordDto.toQuizRecordDto(quizUsersMapping.getQuiz(), quizUsersMapping));
            }
        }

        return QuizRecordHasNextDto.toQuizRecordHasNextDto(hasNext, quizRecordDtos);
    }

    private static boolean isEqualUser(User user, QuizUsersMapping quizUsersMapping) {
        return quizUsersMapping.getUser().getId() == user.getId();
    }
}
