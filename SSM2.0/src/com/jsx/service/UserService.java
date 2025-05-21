package com.jsx.service;

import java.util.List;
import com.jsx.model.User;

public interface UserService {
    String addInfo(User addInfo);
    List<User> getAll();
    String delete(int id);
    User findById(int id);
    String update(User addInfo);
    User login(User user);
}