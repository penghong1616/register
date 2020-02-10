package xyz.ph.dao;

import xyz.ph.pojo.Student;
import xyz.ph.util.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDao {
    public boolean insertStu(Student student){
        int count=0;
        Connection connection= SqlConnection.getConnection();
        PreparedStatement ps = null;
        try {
            ps=connection.prepareStatement("insert into student(name,cla,reg_time) values(?,?,?)");
            ps.setString(1,student.getName());
            ps.setString(2,student.getCla());
            Date date =new Date();
            String str = "yyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(str);
            ps.setString(3,sdf.format(date).toString());
            ps.execute();
            count=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count!=0;
    }
    public List<Student> getAll(){
        List<Student> stus=new ArrayList<>();
        Connection connection =SqlConnection.getConnection();
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("select * from student");

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Student stu=new Student();
                stu.setId(rs.getInt(1));
                stu.setName(rs.getString(2));
                stu.setCla(rs.getString(3));
                stu.setRegTime( rs.getString(4));
                stus.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stus;
    }
}
