package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.Users;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersMapper extends MyMapper<Users> {


    public Users getUserByUsername(String username);


}