package dao;

import org.json.JSONObject;
import org.junit.Test;
import xyz.ph.dao.StudentDao;
import xyz.ph.pojo.Student;

public class TestStuDao {
    @Test
    public void testDao(){
        Student student=new Student();
        student.setName("ph");
        student.setCla("16级软件工程");
        StudentDao studentDao=new StudentDao();
        System.out.println(studentDao.insertStu(student));
    }
    @Test
    public void testQuery(){
        StudentDao studentDao=new StudentDao();
        System.out.println(studentDao.getAll().size());
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",studentDao.getAll().size());
        jsonObject.put("rows",studentDao.getAll());
        System.out.println(jsonObject.toString());
    }
}
