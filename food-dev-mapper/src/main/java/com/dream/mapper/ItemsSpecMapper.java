package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.ItemsSpec;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.List;

public interface ItemsSpecMapper extends MyMapper<ItemsSpec> {


    public List<ItemsSpec> selectSpecById(String itemId);

}