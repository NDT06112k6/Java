package org.example;
import java.rmi.StubNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/school_db";
    private static final String USER = "root";
    private static  final String PASS = "";

    public void addStudent(Student student)
    {
        String sql = "INSERT INTO students (id,ten,gpa) VALUES (?,?,?)";
        try(Connection conn = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setDouble(3,student.getGpa());
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected > 0)
            {
                System.out.println("Da them sinh vien " + student.getId());
            }else
            {
                System.out.println("Them sinh vien that bai " + student.getId());
            }
        }
        catch(SQLException e)
        {
            System.out.println("Loi!" + e.getMessage());
        }
    }
    public Student findById(String id) throws SQLException
    {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try(ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setId(rs.getString("id"));
                    s.setName(rs.getString("ten"));
                    s.setGpa(rs.getDouble("gpa"));
                    return s;
                }
            }
        return null;
    }
    }
    public List<Student> getAllStudents() throws SQLException
    {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DriverManager.getConnection(URL,USER,PASS);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs =  pstmt.executeQuery())
        {
            while(rs.next())
            {
                String id = rs.getString("id");
                String name = rs.getString("ten");
                double gpa = rs.getDouble("gpa");
                Student student = new Student(id,name,gpa);
                list.add(student);
            }
        }
        return list;
    }
    public List<Student> locTheoGPA(Double minGpa) throws SQLException
    {
        List<Student> ketQua = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE gpa >= ?";
        try(Connection conn = DriverManager.getConnection(URL,USER,PASS);
        PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setDouble(1,minGpa);
            try(ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    String id = rs.getString("id");
                    String name = rs.getString("ten");
                    double gpa= rs.getDouble("gpa");
                    Student student = new Student(id,name,gpa);
                    ketQua.add(student);
                }
            }
        }
        return ketQua;
    }
    public boolean updateStudent(Student student) throws SQLException
    {
        String sql ="UPDATE students SET ten = ?, gpa = ? WHERE id = ? ";
        try(Connection conn = DriverManager.getConnection(URL,USER,PASS);
        PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, student.getName());
            pstmt.setDouble(2, student.getGpa());
            pstmt.setString(3, student.getId());
            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;
        }

    }
}
