package com.fsboot.service;

import java.util.List;
import java.util.Optional;

import com.fsboot.dto.UserDto;
import com.fsboot.entities.User;

public interface UserServiceDaoImpl {
	public User insertUser(User user);

	public List<UserDto> getAllUsers();

	public User getSingleUserById(Integer id);

	public Optional<User> updateUserById(User user);

	public Optional<User> deleteUserById(Integer id);

}
