package cn.kgc.dao;

import cn.kgc.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {

    Student getStu(@Param("sid") int sid, @Param("pwd") String pwd);
}
