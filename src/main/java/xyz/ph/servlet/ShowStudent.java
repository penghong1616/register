package xyz.ph.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.ph.dao.StudentDao;
import xyz.ph.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/showStudents")
public class ShowStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao stuDao=new StudentDao();
        List<Student> students=stuDao.getAll();
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=resp.getWriter();
        printWriter.println();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",students.size());
        jsonObject.put("rows",students);

        printWriter.println(jsonObject.toString());
    }
}
