package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.ItemsComments;
import com.dream.pojo.vo.ItemCommentVO;

import java.util.List;
import java.util.Map;

public interface ItemsCommentsMapper extends MyMapper<ItemsComments> {

    public List<ItemCommentVO> getCommentByItemId(Map<String, Object> map);



}