package com.fsboot.dao;

public interface UserSqlQueries {
	String InsQuery = "insert into user(name,address) values(?,?)";
	String SelQuery = "select * from user";
	String SelOneByIdQuery = "select * from user where id=?";
	String Upd_Query = "update user set name=?,address=?" + "where id=?";
	String Del_Query = "delete from user where id =?";

}
