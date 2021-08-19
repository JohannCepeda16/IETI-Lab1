package edu.escuelaing.ieti.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.escuelaing.ieti.data.User;
import edu.escuelaing.ieti.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private HashMap<String, User> users = new HashMap<String, User>();

    public User create(User user) {
        user.setId(String.valueOf(users.size()));
        user.setCreated(true);
        users.put(user.getId(), user);
        return user;
    }

    public User findById(String id) {
        return users.get(id);
    }

    public List<User> all() {
        List<User> userList = new ArrayList<User>();
        for (String key : users.keySet()) {
            userList.add(users.get(key));
        }

        return userList;
    }

    public void deleteById(String id) {
        users.remove(id);
    }

    public User update(User user, String userId) {
        return users.put(userId, user);
    }

}
