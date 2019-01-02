package Service;

import Dao.StudentDao;
import Entity.Student;
import org.json.JSONArray;

public class StudentService {

    public static boolean addStudent(String sno, String sname, int sage, String ssex) {
        boolean result;
        //如果返回值大于0则为true，否则为false
        result = StudentDao.insert(new Student(sno, sname, sage, ssex)) > 0 ? true : false;
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

    public static boolean updateStudent(String sno, String sname, int sage, String ssex, String sno_old) {
        return StudentDao.updateStudent(new Student(sno, sname, sage, ssex), sno_old) > 0 ? true : false;
    }

}
