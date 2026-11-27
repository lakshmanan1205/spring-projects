package com.lionel.library_management_v1.service;

import com.lionel.library_management_v1.dto.user.UserRequest;
import com.lionel.library_management_v1.dto.user.UserResponse;
import com.lionel.library_management_v1.entity.User;

import java.util.List;

public interface UserService {
    public List<UserResponse> findAll();
    public UserResponse findByID(int id);
    public UserResponse save(UserRequest user);
    public User update(User user);
    public void deleteByID(int id);
}
