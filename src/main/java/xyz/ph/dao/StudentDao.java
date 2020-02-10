package xyz.ph.dao;

import xyz.ph.pojo.Student;
import xyz.ph.util.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
    public boolean insertStu(Student student) {
        int count=0;
        Connection connection= SqlConnection.getConnection();
        PreparedStatement ps = null;
        try {
            ps=connection.prepareStatement("insert into student(name,cla) values(?,?)");
            ps.setString(1,student.getName());
            ps.setString(2,student.getCla());
            ps.execute();
            count=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count!=0;
    }
}
