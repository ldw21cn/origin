package net.wanho.service;

import net.wanho.entity.User;
import net.wanho.mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {


    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Resource
    private UserMapper userMapper;

    public User fetchUserByAccount(String account) {
        User user = userMapper.getUserByAccount(account);
        return user;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public boolean addUser(User user) {
        userMapper.insertUser(user);
        System.out.println(1/0);
        return true;
    }

    public boolean updateUser(User user) {
        userMapper.updateUser(user);
        return true;
    }
}
