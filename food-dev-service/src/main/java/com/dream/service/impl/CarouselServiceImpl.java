package com.dream.service.impl;

import com.dream.mapper.CarouselMapper;
import com.dream.pojo.Carousel;
import com.dream.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-04
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        return carouselMapper.getAll(isShow);
    }
}
