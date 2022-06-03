package com.dream.controller;

import com.dream.pojo.Stu;
import com.dream.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    StuService stuService;

    @GetMapping("/getStu/{id}")
    public Stu getStu(@PathVariable("id") Integer id)
    {
        return stuService.getStuInfo(id);
    }

    @PostMapping("/updateStu/{id}")
    public String updateStu(@PathVariable("id") Integer id)
    {
        stuService.updateStu(id);
        return  "OK";
    }





}
