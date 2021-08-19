package edu.escuelaing.ieti.services;

import java.util.List;

import edu.escuelaing.ieti.data.User;

public interface UserService {
    
    User create(User user);

    User findById(String id);

    List<User> all();

    void deleteById(String id);

    User update(User user, String userId);
}
