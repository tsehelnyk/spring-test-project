package com.dev.test;

import com.dev.test.config.AppConfig;
import com.dev.test.model.User;
import com.dev.test.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user1 = new User("joe@gmail.com");
        User user2 = new User("bob@gmail.com");
        User user3 = new User("john@gmail.com");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        System.out.println(userService.listUsers());
    }
}
