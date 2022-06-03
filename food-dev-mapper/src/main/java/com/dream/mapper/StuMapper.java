package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.Stu;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

@Repository
public interface StuMapper extends MyMapper<Stu> {


    Stu getStu(Integer id);
//
    void saveStud(String name, Integer age);
//
    void updateStu(Stu stu);

//    void deleteStu(Integer id);
//

}