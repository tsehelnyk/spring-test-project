package com.dev.test.dao;

import com.dev.test.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAll();
}
