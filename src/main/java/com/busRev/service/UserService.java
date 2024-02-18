package com.busRev.service;

import com.busRev.exception.AdminException;
import com.busRev.exception.UserException;
import com.busRev.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user) throws UserException;
    public User updateUser(User user, String key) throws UserException;
    public User deleteUser(Integer userId, String key) throws UserException, AdminException;
    public User viewUserById(Integer userId, String key) throws UserException, AdminException;
    public List<User> viewAllUser(String key) throws UserException, AdminException;
}
