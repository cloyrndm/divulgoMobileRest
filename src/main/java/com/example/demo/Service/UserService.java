package com.example.demo.Service;

import com.example.demo.Entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Cloie Andrea on 22/07/2018.
 */
public class UserService {
    private final Map<String, User> db;

    public UserService() {
        this.db = new ConcurrentHashMap<>();
    }

    public User lookup(String username) {
        return this.db.get(username);
    }

    public void save(User user) {
        this.db.put(user.getUsername(), user);
    }

    public boolean usernameExists(String username) {
        return this.db.containsKey(username);
    }
}
