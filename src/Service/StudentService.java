package Service;

import Dao.StudentDao;
import Entity.Student;
import org.json.JSONArray;

public class StudentService {

    public static boolean addStudent(String sno, String sname, String sdatebirth, String ssex, String snativeplace, String shouseaddress, String snation) {
        boolean result;
        //如果返回值大于0则为true，否则为false
        result = StudentDao.insert(new Student(sno, sname, sdatebirth, ssex,snativeplace,shouseaddress,snation)) > 0 ? true : false;
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

    public static boolean updateStudent(String sno, String sname, String sdatebirth, String ssex, String snativeplace, String shouseaddress, String snation, String sno_old) {
        return StudentDao.updateStudent(new Student(sno, sname, sdatebirth, ssex,snativeplace,shouseaddress,snation), sno_old) > 0 ? true : false;
    }

}
