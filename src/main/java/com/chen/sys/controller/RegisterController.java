package com.chen.sys.controller;

import com.chen.sys.entity.User;
import com.chen.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName RegisterController
 * @Description: 用户注册
 * @Author chenGJ
 * @Date 2019/12/7 14:00
 * @Version V1.0
**/
@Controller
@RequestMapping("/sys/register")
public class RegisterController {

    @Autowired
    private IUserService userService;

    /**
     * @MethodName: register
     * @Description: 用户注册
     * @Param
     * @Return: java.lang.String
     * @Author: chenGj
     * @Date: 2019/12/7 14:01
    **/
    @RequestMapping("/register")
    public String register(User user){
        User user1 = userService.getUser(user.getUsername());
        //用户名已存在
        if(null == user1){
            //两次输入的密码不一致
            if(!user.getPassword().equals(user.getRepassword())){
                return "register";
            }
        }
        //添加用户
        int count = userService.addUser(user);
        if(count == 1){
            return "login";
        }
        //添加用户出现异常
        return "register";
    }
}
