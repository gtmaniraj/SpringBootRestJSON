package com.fsboot.service;

import com.fsboot.dto.UserDto;
import com.fsboot.entities.User;

public interface UserServiceDaoImpl {
    public int insertUser(String name, String address);
    public Object getAllUsers();
    public Object getSingleUserById(Integer id);
    public int updateUserById(int id,String name,String address);
    public int deleteUserById(Integer id);
    public User dtoToModel(UserDto userDto);
}
