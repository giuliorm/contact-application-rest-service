package ru.juriasan.clientrequestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
// With @WebServlet annotation the webapp/WEB-INF/web.xml is no longer required.
@WebServlet(name = "PostgreSQL",
        urlPatterns = "/db")
public class PostgreSQLServlet extends HttpServlet {

    private Connection conn;

    @Override
    public void init() throws ServletException {
        String url = System.getProperty("cloudsql");
        log("connecting to: " + url);
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to PostgreSQL", e);
        }
    }

    class Result {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
        ServletException {

        String path = req.getRequestURI();
        if (path.startsWith("/favicon.ico")) {
            return; // ignore the request for favicon.ico
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        final String tableName = "t1";
        final String selectAll = "select * from " + tableName + ";";
        List<Result> results = new ArrayList<>();
       // Connection conn;
//        try {
//            conn = DriverManager.getConnection(url);
//
//        } catch (Exception e) {
//            throw new RuntimeException("Unable to connect to Cloud SQL", e);
//        }

        try (Statement st = conn.createStatement()) {
            try (ResultSet result = st.executeQuery(selectAll)) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    Result res = new Result();
                    res.setId(id);
                    res.setName(name);
                    results.add(res);
                    out.println("Id " + id + " name " + name);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Unable to connect to Cloud SQL", ex);
        }
    }
}
