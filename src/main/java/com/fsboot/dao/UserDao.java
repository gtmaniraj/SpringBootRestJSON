package com.fsboot.dao;

import com.fsboot.dto.UserDto;
import com.fsboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao implements UserSqlQueries {
    @Autowired
    private JdbcTemplate jdbcTemplateObj;
    @Autowired
    private User user;
    private DataSource dataSource;
    public DataSource getDataSource() {
        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObj=new JdbcTemplate(dataSource);
    }
    public int insData(String name, String address )
    {
        int insertedRows= jdbcTemplateObj.update(InsQuery,name,address);
        return insertedRows;
    }
    public int delData(int id )
    {
        int delRows= jdbcTemplateObj.update(Del_Query,id);
        return delRows;
    }
    public List<UserDto> AllUsers()
    {
        List<UserDto> allUsers=jdbcTemplateObj.query(SelQuery,(rs,row_num)-> new UserDto(rs.getInt("id"),rs.getString("name"),rs.getString("address")));
        return allUsers;
    }
    public UserDto getSingleUser(Integer id) {

        UserDto sinUsers=jdbcTemplateObj.queryForObject(SelOneByIdQuery,new Object[]{id},(rs,row_num)-> new UserDto(rs.getInt("id"),rs.getString("name"),rs.getString("address")));
        return sinUsers;
    }
    public int updUsers(int id,String name ,String address) {
        return jdbcTemplateObj.update(Upd_Query,name,address,id);
    }
}
