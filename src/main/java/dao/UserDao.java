package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    void saveUser(User user);
    User login(String username,String password);
}
