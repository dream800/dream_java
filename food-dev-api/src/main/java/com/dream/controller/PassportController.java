package com.dream.controller;

import com.dream.pojo.Stu;
import com.dream.pojo.Users;
import com.dream.pojo.bo.UserBO;
import com.dream.service.StuService;
import com.dream.service.UserService;
import com.dream.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
@Api(value = "注册登录", tags = {"用于注册登录"})
@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户注册", httpMethod = "POST")
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult register(String username)
    {
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("sorry, username can not empty...");
        }

        boolean b = userService.checkUserNameIsExist(username);

        if (!b) {
            return IMOOCJSONResult.errorMsg("username is exist...");
        }

        return IMOOCJSONResult.ok();
    }


    @PostMapping("/regist")
    public IMOOCJSONResult register(@RequestBody UserBO userBO)
    {
        if (StringUtils.isBlank(userBO.getUsername())) {
            return IMOOCJSONResult.errorMsg("username can not empty...");
        }

        if (StringUtils.isBlank(userBO.getPassword())) {
            return IMOOCJSONResult.errorMsg("password can not empty...");
        }


        if (StringUtils.isBlank(userBO.getConfirmPassword())) {
            return IMOOCJSONResult.errorMsg("confirmPassword can not empty...");
        }


        if (!Objects.equals(userBO.getPassword(), userBO.getConfirmPassword())) {
            return IMOOCJSONResult.errorMsg("password is not same...");
        }

        Users user = userService.createUser(userBO);
        System.out.println(user);

        return IMOOCJSONResult.ok();
    }


    @ApiOperation(value = "登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody UserBO userBO)
    {

        if (StringUtils.isBlank(userBO.getUsername())) {
            return IMOOCJSONResult.errorMsg("username can not empty...");
        }

        if (StringUtils.isBlank(userBO.getPassword())) {
            return IMOOCJSONResult.errorMsg("password can not empty...");
        }

        Users user = userService.login(userBO);
        System.out.println(user);
        if(user == null) {
            IMOOCJSONResult.errorMsg("username or password is wrong...");
        }

        return IMOOCJSONResult.ok(user);
    }



}
