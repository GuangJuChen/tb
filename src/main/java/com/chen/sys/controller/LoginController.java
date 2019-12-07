package com.chen.sys.controller;

import com.chen.sys.entity.User;
import com.chen.sys.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName LoginController
 * @Description: 用户登录
 * @Author chenGJ
 * @Date 2019/12/7 9:35
 * @Version V1.0
**/
@Controller
@RequestMapping("/sys/login")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService userService;

    /**
     * @MethodName: login
     * @Description: 登录
     * @Param user
     * @Return: java.lang.String
     * @Author: chenGj
     * @Date: 2019/12/7 13:58
    **/
    @RequestMapping("/login")
    public String login(User user){
        User user1 = userService.getUser(user.getUsername());
        logger.info(String.valueOf(user1));
        //用户名错误
        if(null != user1){
            if(!user1.getUsername().equals(user.getUsername())){
                return "login";
            }else{
                //密码错误
                if(!user1.getPassword().equals(user.getPassword())){
                    return "login";
                }
            }
            return "index";
        }
        return "login";
    }

    /**
     * @MethodName: register
     * @Description: 跳转注册页面
     * @Return: java.lang.String
     * @Author: chenGj
     * @Date: 2019/12/7 14:39
    **/
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
