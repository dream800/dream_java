package com.dream.service.impl;

import com.dream.mapper.StuMapper;
import com.dream.pojo.Stu;
import com.dream.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
@Service
public class TestStuServiceImpl {

    @Autowired
    StuMapper stuMapper;

    public void saveParent()
    {
        int i = new Random().nextInt(100);
        stuMapper.saveStud("parent_" + i, i);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveChildren()
    {
        saveChildren1();

//        int a = 0;
//        int b = 1 / a;

        saveChildren2();
    }

    public void saveChildren1()
    {
        int i = new Random().nextInt(100) + 100;
        stuMapper.saveStud("child1_" + i, i);
    }

    public void saveChildren2()
    {
        int i = new Random().nextInt(100) + 200;
        stuMapper.saveStud("child2_" + i, i);
    }
}
