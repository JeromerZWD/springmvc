package service;

import entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void saveUser(User user);
    User login(String username,String password);
}
