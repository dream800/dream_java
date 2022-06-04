package com.dream.service.impl;

import com.dream.mapper.UsersMapper;
import com.dream.pojo.Users;
import com.dream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-04
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public boolean checkUserNameIsExist(String username) {
        Users user = usersMapper.getUserByUsername(username);

        if (user == null) {
            return false;
        }

        return true;
    }
}
