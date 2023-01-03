package com.fsboot.controller;


import com.fsboot.service.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class UserController  {
    @Autowired
    private UserServiceDao userServiceDao;
    @GetMapping("/search/{id}")
    public Object Search(@PathVariable("id") int id) {
        return this.userServiceDao.getSingleUserById(id);
    }
    @GetMapping("/index")
      public Object Index()
    {
        return userServiceDao.getAllUsers();
    }
    @PostMapping("/save")
    public int Save(@Param("name") String name,@Param("address") String address)
   {
        return userServiceDao.insertUser(name, address);
    }
    @PostMapping("/update/{id}")
    public int Update(@PathVariable("id") int id,@Param("name") String name,@Param("address") String address)
    {
        return userServiceDao.updateUserById(id,name,address);
    }
    @PostMapping("/delete/{id}")
    public int Delete(@PathVariable("id") int id)
    {
        return userServiceDao.deleteUserById(id);
    }
}
