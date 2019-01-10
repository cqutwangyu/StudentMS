package com.studentsm.service.impl;

import com.studentsm.dao.StudentDao;
import com.studentsm.dao.impl.StudentDaoImpl;
import com.studentsm.entity.Student;
import com.studentsm.service.StudentService;
import org.json.JSONArray;

/**
 * 学生类业务实现
 * @author WangYu
 */
public class StudentServiceImpl implements StudentService {
    private static StudentDao studentDao=new StudentDaoImpl();
    /**
     * 初始化数据库中的学生表数据
     */
    @Override
    public void initDB() {
        studentDao.initDateStudentDB();
    }

    /**
     * 添加一个学生
     */
    @Override
    public boolean addStudent(String sno, String sname, String sdatebirth, String ssex, String snativeplace, String shouseaddress, String snation) {
        boolean result;
        //如果返回值大于0则为true，否则为false
        result = studentDao.insert(new Student(sno, sname, sdatebirth, ssex, snativeplace, shouseaddress, snation)) > 0;
        return result;
    }

    /**
     * 查询学号是否已存在
     *
     * @param sno 学号
     * @return 存在为true，不存在为false
     */
    @Override
    public boolean isExist(String sno) {
        boolean result;
        //返回的是一个json数组，如果这个json数组内存储的数据个数大于0则表示存在，result为true
        result = studentDao.queryStudents("sno", sno).length() > 0;
        return result;
    }

    /**
     * 查询学生信息
     *
     * @param key   查询的字段
     * @param value 查询的值
     * @return 查询的结果json数组格式
     */
    @Override
    public JSONArray queryStudent(String key, String value) {
        return studentDao.queryStudents(key, value);
    }

    /**
     * 查询所有学生信息
     *
     * @return 所有的学生信息，json数组格式
     */
    @Override
    public JSONArray queryStudents() {
        return (JSONArray) studentDao.queryStudents();
    }

    /**
     * 删除学生信息
     *
     * @param sno 学号
     * @return 是否删除成功
     */
    @Override
    public boolean deleteStudent(String sno) {
        // 返回值为删除语句影响的行数，如果大于0表示删除成功
        return studentDao.deleteStudent(sno) > 0;
    }

    /**
     * 修改学生信息
     *
     * @param sno           修改后的学号
     * @param sname         修改后的姓名
     * @param sdatebirth    修改后的出生日期
     * @param ssex          修改后的性别
     * @param snativeplace  修改后的籍贯
     * @param shouseaddress 修改后的家庭地址
     * @param snation       修改后的民族
     * @param snoOld        修改前的学号
     * @return 是否修改成功
     */
    @Override
    public boolean updateStudent(String sno, String sname, String sdatebirth, String ssex, String snativeplace, String shouseaddress, String snation, String snoOld) {
        // 返回值为删除语句影响的行数，如果大于0表示删除成功
        return studentDao.updateStudent(new Student(sno, sname, sdatebirth, ssex, snativeplace, shouseaddress, snation), snoOld) > 0;
    }

}
