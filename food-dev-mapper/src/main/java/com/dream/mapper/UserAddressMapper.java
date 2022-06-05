package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.UserAddress;

import java.util.List;

public interface UserAddressMapper extends MyMapper<UserAddress> {


    public void insertAddress(UserAddress userAddress);


    public List<UserAddress> selectAddressByUid(String userId);


    public UserAddress selectUserAddress(String addressId, String userId);



}