package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.Category;
import com.dream.pojo.vo.CategoryVO;
import com.dream.pojo.vo.NewItemsVO;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public interface CategoryMapper extends MyMapper<Category> {


    public List<Category> getAll(Integer type);


    public List<CategoryVO> getCategoryByRootId(Integer rootId);


    public List<NewItemsVO> getItemsByCategory(Map<String, Object> map);


}