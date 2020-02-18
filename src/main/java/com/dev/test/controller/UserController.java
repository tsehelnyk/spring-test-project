package com.dev.test.controller;

import com.dev.test.dto.UserResponseDto;
import com.dev.test.model.User;
import com.dev.test.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/inject", method = RequestMethod.GET)
    public String addUsers() {

        userService.add(new User("joe@gmail.com", "Joe"));
        userService.add(new User("bob@gmail.com", "Bob"));
        userService.add(new User("john@gmail.com", "John"));
        userService.add(new User("lenny@gmail.com", "Lenny"));
        return "users injected";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserResponseDto getUser(@PathVariable Long userId) {
        User user = userService.get(userId);
        return new UserResponseDto(user.getEmail(), user.getName());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserResponseDto> getAll(Long id) {
        return userService.listUsers().stream()
                .map(u -> {
                    return new UserResponseDto(u.getEmail(), u.getName());
                })
                .collect(Collectors.toList());
    }

}
