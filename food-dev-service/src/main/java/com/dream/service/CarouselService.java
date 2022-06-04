package com.dream.service;

import com.dream.pojo.Carousel;
import com.dream.pojo.Users;
import com.dream.pojo.bo.UserBO;

import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
public interface CarouselService {

    public List<Carousel> queryAll(Integer isShow);

}
