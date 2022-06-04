package com.dream.controller;

import com.dream.pojo.Stu;
import com.dream.pojo.Users;
import com.dream.pojo.bo.UserBO;
import com.dream.service.StuService;
import com.dream.service.UserService;
import com.dream.utils.CookieUtils;
import com.dream.utils.IMOOCJSONResult;
import com.dream.utils.JsonUtils;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.Optional;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
@Api(value = "注册登录", tags = {"用于注册登录"})
@RestController
@RequestMapping("/passport")
@Slf4j
public class PassportController {

//    public static final Logger logger = LoggerFactory.getLogger(PassportController.class);

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
    public IMOOCJSONResult login(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response)
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

//        session.setMaxInactiveInterval(10);
//        session.setAttribute("userinfo", user);

        user.setSex(null);
        user.setFace(null);
        user.setBirthday(null);

        String s = JsonUtils.objectToJson(user);
//        System.out.println(s);

        CookieUtils.setCookie(request, response, "user", s, true);


        log.info("I love you");
        log.debug("I love you ,too...");


        return IMOOCJSONResult.ok(user);
    }



    @ApiOperation(value = "退出登录", notes = "退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public IMOOCJSONResult logout(HttpServletRequest request, HttpServletResponse response)
    {
        String user = CookieUtils.getCookieValue(request, "user", true);

        user = StringUtils.isEmpty(user) ? "{}" : user;

        Object userObj = JsonUtils.jsonToPojo(user, Users.class);

//        System.out.println(userObj);

        CookieUtils.deleteCookie(request, response, "user");

        return IMOOCJSONResult.ok(userObj);
    }



}
