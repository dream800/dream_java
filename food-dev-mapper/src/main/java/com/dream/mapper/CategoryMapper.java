package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.Category;
import com.dream.pojo.vo.CategoryVO;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryMapper extends MyMapper<Category> {


    public List<Category> getAll(Integer type);


    public List<CategoryVO> getCategoryByRootId(Integer rootId);

}