package com.fsboot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.fsboot.dto.UserDto;

public class UserMapper implements RowMapper<UserDto> {

	    @Override
	    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	UserDto userDto = new UserDto();
	    	userDto.setId(rs.getInt("id"));
	    	userDto.setName(rs.getString("name"));
	    	userDto.setAddress(rs.getString("address"));
	    	return userDto;
	    }
	}
