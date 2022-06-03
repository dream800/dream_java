package com.test;

import com.dream.Application;
import com.dream.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TransTest {


    @Autowired
    StuService stuService;

    @Test
    public void myTest()
    {
//        stuService.updateStu(1203);
    }


}
