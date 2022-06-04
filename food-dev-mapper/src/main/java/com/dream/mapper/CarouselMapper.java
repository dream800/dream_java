package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.Carousel;

import java.util.List;

public interface CarouselMapper extends MyMapper<Carousel> {


    public List<Carousel> getAll(Integer isShow);


}