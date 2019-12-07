package com.chen.sys.service;

import com.chen.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenGJ
 * @since 2019-12-05
 */
public interface IUserService extends IService<User> {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 查询用户
     * @return
     */
    User getUser(String username);
}
