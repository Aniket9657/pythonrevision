package com.Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewStudentsServlet extends HttpServlet {

    private static final String URL = "jdbc:postgresql://localhost:5433/student_teacher_db";
    private static final String USER = "postgres";
    private static final String PASS = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>📋 Student List</h2>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>");

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM studentclass");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }
}
