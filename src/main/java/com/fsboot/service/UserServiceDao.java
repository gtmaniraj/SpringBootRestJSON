package com.fsboot.service;

import com.fsboot.dao.UserDao;
import com.fsboot.dao.UserSqlQueries;
import com.fsboot.dto.UserDto;
import com.fsboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDao implements UserServiceDaoImpl, UserSqlQueries {
    @Autowired
    private UserDao userDao;
    @Override
    public int insertUser(String name, String address)
    {
        return userDao.insData(name,address);
    }
    @Override
    public Object getAllUsers() {
        return userDao.AllUsers();
    }
    @Override
    public Object getSingleUserById(Integer id) {
        return userDao.getSingleUser(id);
    }
    @Override
    public int updateUserById(int id,String name,String address) {
        return userDao.updUsers(id,name,address);

    }
    @Override
    public int deleteUserById(Integer id) {
        return userDao.delData(id);
    }
    @Override
    public User dtoToModel(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        return user;
    }
}
