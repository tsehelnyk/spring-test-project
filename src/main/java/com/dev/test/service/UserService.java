package com.dev.test.service;

import com.dev.test.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
