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
public class StuServiceImpl implements StuService {

    @Autowired
    StuMapper stuMapper;

    @Autowired
    TestStuServiceImpl testStuService;

    @Override
    public Stu getStuInfo(Integer id) {
        return stuMapper.getStu(id);
    }

    @Override
    public void saveStud() {

        stuMapper.saveStud("dream4", 30);
    }

//    @Transactional(rollbackFor = Exception.class)
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStu(Integer id) {
//        Stu stu = new Stu();
//        stu.setName("dream3");
//        stu.setId(1203);
//        stuMapper.updateStu(stu);
//
//        stuMapper.saveStud("dream4", 30);

//        try {
//            int a = 0;
//            int b = id / a;
//        } catch (Exception e) {
//            throw new Exception("haha");
//        }




        testStuService.saveParent();
//        int a = 0;
//        int b = id / a;
        testStuService.saveChildren();

        int a = 0;
        int b = id / a;

    }

    @Override
    public void deleteStu(Integer id) {

    }
//
//    public void saveParent()
//    {
//        int i = new Random().nextInt(100);
//        stuMapper.saveStud("dream_" + i, i);
//    }
//
////    @Transactional(propagation = Propagation.REQUIRED)
//    public void saveChildren()
//    {
//        saveChildren1();
//
//        int a = 0;
//        int b = 1 / a;
//
//        saveChildren2();
//    }
//
//    public void saveChildren1()
//    {
//        int i = new Random().nextInt(100) + 100;
//        stuMapper.saveStud("child1_" + i, i);
//    }
//
//    public void saveChildren2()
//    {
//        int i = new Random().nextInt(100) + 200;
//        stuMapper.saveStud("child2_" + i, i);
//    }
}
