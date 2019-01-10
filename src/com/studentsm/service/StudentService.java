package com.studentsm.service;

import org.json.JSONArray;

/**
 *  学生类的业务层接口
 */
public interface StudentService {
    /**
     * 初始化数据库信息
     */
    void initDB();

    /**
     * 增加操作
     * @param sno
     * @param sname
     * @param sdatebirth
     * @param ssex
     * @param snativeplace
     * @param shouseaddress
     * @param snation
     * @return
     */
    boolean addStudent(String sno, String sname, String sdatebirth, String ssex, String snativeplace, String shouseaddress, String snation);

    /**
     * 查重操作
     * @param sno
     * @return
     */
    boolean isExist(String sno);

    /**
     * 根据key查询
     * @param key 字段名
     * @param value 值
     * @return
     */
    JSONArray queryStudent(String key, String value);

    /**
     * 查询所有
     * @return
     */
    JSONArray queryStudents();

    /**
     * 根据sno删除
     * @param sno 学号值
     * @return
     */
    boolean deleteStudent(String sno);

    /**
     * 根据旧学号做修改操作
     * @param sno 新学号
     * @param sname
     * @param sdatebirth
     * @param ssex
     * @param snativeplace
     * @param shouseaddress
     * @param snation
     * @param snoOld 旧学号
     * @return
     */
    boolean updateStudent(String sno, String sname, String sdatebirth, String ssex, String snativeplace, String shouseaddress, String snation, String snoOld);
}
