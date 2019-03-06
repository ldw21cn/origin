package net.wanho.mapper;

import net.wanho.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    void insertUser(User user);

    User getUserByAccount(@Param("account") String account);

    void updateUser(User user);
}
