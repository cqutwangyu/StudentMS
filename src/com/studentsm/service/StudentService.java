package com.studentsm.service;

import com.studentsm.dao.StudentDao;
import com.studentsm.entity.Student;
import org.json.JSONArray;

/**
 * @author WangYu
 */
public class StudentService {

    public static void initDB(){
        StudentDao.initDateStudentDB();
    }
    public static boolean addStudent(String sno, String sname, String sdatebirth, String ssex, String snativeplace, String shouseaddress, String snation) {
        boolean result;
        //如果返回值大于0则为true，否则为false
         result = StudentDao.insert(new Student(sno, sname, sdatebirth, ssex,snativeplace,shouseaddress,snation)) > 0 ? true : false;
        return result;
    }

    public static boolean isExist(String sno){
        boolean result;
        result=(StudentDao.queryStudents("sno", sno).length()>0)?true:false;
        System.out.println(StudentDao.queryStudents("sno", sno).length());
        return result;
    }

    public static JSONArray queryStudent(String key,String value) {
        return StudentDao.queryStudents(key, value);
    }

    public static JSONArray queryStudents() {
        return StudentDao.queryStudents();
    }

    public static boolean deleteStudent(String sno) {
        return StudentDao.deleteStudent(sno) > 0 ? true : false;
    }

    public static boolean updateStudent(String sno, String sname, String sdatebirth, String ssex, String snativeplace, String shouseaddress, String snation, String snoOld) {
        return StudentDao.updateStudent(new Student(sno, sname, sdatebirth, ssex,snativeplace,shouseaddress,snation), snoOld) > 0 ? true : false;
    }

}
