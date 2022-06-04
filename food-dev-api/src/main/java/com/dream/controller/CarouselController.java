package com.dream.controller;

import com.dream.enums.YesOrNo;
import com.dream.pojo.Carousel;
import com.dream.pojo.Users;
import com.dream.pojo.bo.UserBO;
import com.dream.service.CarouselService;
import com.dream.service.UserService;
import com.dream.utils.CookieUtils;
import com.dream.utils.IMOOCJSONResult;
import com.dream.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;


/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
@Api(value = "轮播图", tags = {"轮播图"})
@RestController
@Slf4j
@RequestMapping("/index")
public class CarouselController {


    @Autowired
    CarouselService carouselService;

    @ApiOperation(value = "用户名是否存在", notes = "用户注册", httpMethod = "POST")
    @GetMapping("/carousel")
    public IMOOCJSONResult carousel()
    {
        List<Carousel> carousels = carouselService.queryAll(YesOrNo.YES.type);


        return IMOOCJSONResult.ok(carousels);
    }




}
