package com.dream.service.impl;

import com.dream.mapper.CarouselMapper;
import com.dream.mapper.CategoryMapper;
import com.dream.mapper.CategoryMapperCustom;
import com.dream.pojo.Carousel;
import com.dream.pojo.Category;
import com.dream.pojo.vo.CategoryVO;
import com.dream.pojo.vo.NewItemsVO;
import com.dream.service.CarouselService;
import com.dream.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> queryAllRootLevelCat() {

        List<Category> result = categoryMapper.getAll(1);

        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
//        return categoryMapperCustom.getSubCatList(rootCatId);

        List<CategoryVO> category = categoryMapper.getCategoryByRootId(rootCatId);
        return  category;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {

        Map<String, Object> map = new HashMap<>();
        map.put("rootCatId", rootCatId);

        return categoryMapperCustom.getSixNewItemsLazy(map);
    }
}
