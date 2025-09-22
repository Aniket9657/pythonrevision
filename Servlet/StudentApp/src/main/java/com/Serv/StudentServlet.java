package com.Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class StudentServlet extends HttpServlet {

    // Database details
    private static final String URL = "jdbc:postgresql://localhost:5433/student_teacher_db";
    private static final String USER = "postgres";
    private static final String PASS = "root";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            // Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");
            
            // Connect to DB
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            // Insert query
            String sql = "INSERT INTO studentclass(name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                out.println("<h2>✅ Student Added Successfully!</h2>");
            } else {
                out.println("<h2>❌ Failed to Add Student</h2>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace(out);
        }
    }
}
