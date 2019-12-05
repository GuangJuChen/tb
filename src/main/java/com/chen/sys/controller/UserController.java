package com.chen.sys.controller;


import com.chen.sys.entity.User;
import com.chen.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenGJ
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * @MethodName: addUser
     * @Description: 添加用户
     * @Param
     * @Return: java.lang.String
     * @Author: chenGj
     * @Date: 2019/12/5 22:35
    **/
    @RequestMapping("/add")
    public User addUser(User user){
        System.out.println(11111);
        return userService.addUser(user);
    }

}
