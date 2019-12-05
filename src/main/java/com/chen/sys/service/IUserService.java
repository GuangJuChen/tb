package com.chen.sys.service;

import com.chen.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
    User addUser(User user);
}
