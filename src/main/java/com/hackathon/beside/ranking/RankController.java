package com.hackathon.beside.ranking;

import com.hackathon.beside.common.annotation.LoggedInUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RankController {

    private final RankService rankService;

    @GetMapping("/rank/total")
    public TotalRankDto totalRank(
            @LoggedInUserId Long userId,
            @RequestParam("interest") String interest
    ) {
        System.out.println("userId = " + userId);
        return rankService.getUserRank(userId, interest);
    }

    @GetMapping("/rank/school")
    public TotalSchoolDto totalSchoolRank(
            @LoggedInUserId Long userId,
            @RequestParam("interest") String interest
    ) {
        return rankService.getSchoolRank(userId, interest);
    }
}