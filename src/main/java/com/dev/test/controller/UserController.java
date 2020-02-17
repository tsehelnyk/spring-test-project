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

        User user1 = new User("joe@gmail.com", "Joe");
        User user2 = new User("bob@gmail.com", "Bob");
        User user3 = new User("john@gmail.com", "John");
        User user4 = new User("lenny@gmail.com", "Lenny");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        return "users injected";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserResponseDto getUser(@PathVariable Long userId) {
        User user = userService.get(userId);
        UserResponseDto userDto = new UserResponseDto(user.getEmail(), user.getName());
        return userDto;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserResponseDto> getAll(Long id) {
        return userService.listUsers().stream()
                .map(u -> {
                    UserResponseDto userDto = new UserResponseDto(u.getEmail(), u.getName());
                    return userDto;
                })
                .collect(Collectors.toList());
    }

}
