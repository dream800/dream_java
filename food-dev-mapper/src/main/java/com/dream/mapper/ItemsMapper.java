package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.Items;

public interface ItemsMapper extends MyMapper<Items> {

    public Items getItem(String itemId);

}