package com.fsboot.dao;

import com.fsboot.dto.UserDto;
import com.fsboot.entities.User;
import com.fsboot.mapper.UserMapper;
import com.fsboot.repo.UserRepo;
import com.fsboot.utils.UserConstants;
import com.fsboot.entities.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao implements UserSqlQueries, UserConstants {
	@Autowired
	private JdbcTemplate jdbcTemplateObj;

	@Autowired
	private UserRepo userRepo;
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	public User insData(User user) {
		return userRepo.save(user);
	}

	public Optional<User> delData(int id) {
		Optional<User> user=userRepo.findById(id);
		 userRepo.deleteById(id);
		 return user;
	}

	public List<UserDto> AllUsers() {
		return jdbcTemplateObj.query(SelQuery,new UserMapper());
		}

	public User getSingleUser(Integer id) {
		return userRepo.findById(id).get();
	}

	public Optional<User> updUsers(User user) {
		jdbcTemplateObj.update(Upd_Query,user.getName(),user.getAddress(),user.getId());
		return userRepo.findById(user.getId());
	}
}
