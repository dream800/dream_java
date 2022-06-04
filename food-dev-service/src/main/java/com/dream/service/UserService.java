package com.dream.service;

import com.dream.pojo.Stu;
import com.dream.pojo.Users;
import com.dream.pojo.bo.UserBO;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
public interface UserService {


    boolean checkUserNameIsExist(String username);


    /**
     * 用户注册
     *
     * @param userBO
     * @return
     */
    public Users createUser(UserBO userBO);

}
