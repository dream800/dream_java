package com.dream.service.impl;

import com.dream.enums.Sex;
import com.dream.mapper.UsersMapper;
import com.dream.pojo.Users;
import com.dream.pojo.bo.UserBO;
import com.dream.service.UserService;
import com.dream.utils.DateUtil;
import com.dream.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-04
 */
@Service
public class UserServiceImpl implements UserService {

    public static final String USER_FACE = "https://gimg3.baidu.com/rel/src=https%3A%2F%2Fbkimg.cdn.bcebos.com%2Fsmart%2Fe61190ef76c6a7eff1edd899f5faaf51f2de6641-bkimg-process%2Cv_1%2Crw_3%2Crh_2%2Cmaxl_700&refer=http%3A%2F%2Fwww.baidu.com&app=2010&size=f256,170&n=0&g=0n&q=100&fmt=auto?sec=1654448400&t=e5bdb762a5f239c348d78f32354a74f2";


    @Autowired
    UsersMapper usersMapper;

    @Autowired
    Sid sid;

    @Override
    public boolean checkUserNameIsExist(String username) {
        Users user = usersMapper.getUserByUsername(username);

//
//        Users userTest = usersMapper.getUserTest();
//        System.out.println(userTest);


        if (user == null) {
            return false;
        }

        return true;
    }

//    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {

        Users users = new Users();
        users.setUsername(userBO.getUsername());
        String md5Str = null;
        try {
            md5Str = MD5Utils.getMD5Str(userBO.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        users.setPassword(md5Str);
        users.setNickname(userBO.getUsername());
        users.setFace(USER_FACE);
        users.setBirthday(DateUtil.stringToDate("1970-01-01"));
        users.setSex(Sex.secret.type);
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());

        String s = sid.nextShort();
        users.setId(s);

        Integer user1 = usersMapper.createUser(users);

        System.out.println(user1);
        return users;
    }


    @Override
    public Users login(UserBO userBO) {
        String password = userBO.getPassword();
        String md5Str = null;
        try {
            md5Str = MD5Utils.getMD5Str(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Users user = usersMapper.login(userBO.getUsername(), md5Str);

        return user;
    }
}
