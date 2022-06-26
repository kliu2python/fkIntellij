package com.example.springmvctemplate.DAO;
import com.example.springmvctemplate.model.User;

public interface UserDAO {
    public int registerUser(User user);

    public String loginUser(User user);
}
