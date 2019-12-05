package com.chen.sys.service.impl;

import com.chen.sys.entity.User;
import com.chen.sys.mapper.UserMapper;
import com.chen.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenGJ
 * @since 2019-12-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User addUser(User user) {
        return null;
    }
}
