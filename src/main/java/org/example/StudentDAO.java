package org.example;
import java.sql.*;
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
}
