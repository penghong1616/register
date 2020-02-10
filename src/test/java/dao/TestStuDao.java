package dao;

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
}
