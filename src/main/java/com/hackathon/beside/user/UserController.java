package com.hackathon.beside.user;

import com.hackathon.beside.common.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{userId}/profile")
    public User getProfile(
            @PathVariable("userId") long userId
    ) {

        return userService.getProfile(userId);
    }
}
