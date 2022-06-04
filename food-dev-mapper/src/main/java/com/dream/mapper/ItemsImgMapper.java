package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.ItemsImg;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public interface ItemsImgMapper extends MyMapper<ItemsImg> {

    public List<ItemsImg> selectImgById(String itemId);

}