package kaola.com.test.service.impl;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 21:13 2018/1/28
 *@Modified By:
 */

import kaola.com.test.mapper.UserMapper;
import kaola.com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserServiceImpl implements UserService {


    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
