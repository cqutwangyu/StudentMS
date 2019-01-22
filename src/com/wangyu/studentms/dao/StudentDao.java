package com.wangyu.studentms.dao;

import com.wangyu.studentms.entity.Student;
import org.json.JSONArray;

/**
 * 学生类的持久层接口
 */
public interface StudentDao {

    /**
     * 初始化数据库中的测试数据
     */
    void initDateStudentDB();

    /**
     * 插入一条学生信息
     * @param s 学生信息存储对象
     * @return
     */
    int insert(Student s);

    /**
     * 修改一条学生信息
     * @param s 修改信息后的学生对象
     * @param snoOld 被修改的学生对象原学号
     * @return
     */
    int updateStudent(Student s, String snoOld);

    /**
     * 查询数据库中的students表，根据k字段查询包含v数据的记录
     * @param k 查询字段
     * @param v 查询值
     * @return
     */
    JSONArray queryStudents(String k, String v);

    /**
     * 查询所有学生信息
     * @return 返回一个包含所有学生信息的json数组
     */
     JSONArray queryStudents();

    /**
     * 删除一条学生记录
     * @param sno 被删除学生的学号
     * @return
     */
     int deleteStudent(String sno);
}
