package com.dream.service;

import com.dream.pojo.Stu;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
public interface StuService {


    Stu getStuInfo(Integer id);

    void saveStud();

    void updateStu(Integer id);

    void deleteStu(Integer id);


}
