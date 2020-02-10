package xyz.ph.servlet;

import xyz.ph.dao.StudentDao;
import xyz.ph.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String cla=req.getParameter("cla");
        Student stu=new Student();
        stu.setName(name);
        stu.setCla(cla);
        StudentDao stuDao=new StudentDao();
        stuDao.insertStu(stu);
        PrintWriter pw=resp.getWriter();
        pw.println("200");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
