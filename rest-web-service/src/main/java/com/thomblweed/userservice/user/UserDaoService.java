package com.thomblweed.userservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 1;

    static {
        users.add(new User(1, "Thomas", new Date()));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User save(User user) {
        Integer userId = user.getId();

        for (User existingUser : users) {
            if (existingUser.getId() == userId) {
                return existingUser;
            }
        }

        if (userId == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
