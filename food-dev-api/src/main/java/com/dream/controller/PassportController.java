package com.dream.controller;

import com.dream.pojo.Stu;
import com.dream.service.StuService;
import com.dream.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    UserService userService;

    @GetMapping("/usernameIsExist")
    public boolean register(String username)
    {
        if (StringUtils.isBlank(username)) {
            System.out.println("sorry, username can not empty...");
            return false;
        }

        boolean b = userService.checkUserNameIsExist(username);
        System.out.println(b);
        return b;
    }







}
