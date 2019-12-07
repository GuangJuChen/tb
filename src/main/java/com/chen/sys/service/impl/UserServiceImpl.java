package com.chen.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.sys.entity.User;
import com.chen.sys.mapper.UserMapper;
import com.chen.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private UserMapper userMapper;

    /**
     * @MethodName: addUser
     * @Description: 添加用户
     * @Param user
     * @Return: com.chen.sys.entity.User
     * @Author: chenGj
     * @Date: 2019/12/7 14:13
    **/
    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * @MethodName: getUserList
     * @Description: 查询所有用户
     * @Return: java.util.List<com.chen.sys.entity.User>
     * @Author: chenGj
     * @Date: 2019/12/7 9:41
    **/
    @Override
    public User getUser(String username) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("username",username));
    }
}
