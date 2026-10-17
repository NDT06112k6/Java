package org.example;

import com.mysql.cj.protocol.a.SqlDateValueEncoder;

import java.sql.SQLException;
import java.util.List;

public class Main {
    static void main(String[] args) {
        StudentDAO std = new StudentDAO();
        String id = "135";
        Double minGpa = 3.7;
        try{
            Student s = std.findById(id);
            if(s!=null)
            {
                System.out.println("da tim thay sinh vien " + id);
            }else
            {
                System.out.println("Khong ton tai id " + id);
            }
        }catch (SQLException e)
        {
            System.out.println("Loi " + e.getMessage());
        }
        try {
            List<Student> studentList = std.getAllStudents();
            if(studentList.isEmpty())
            {
                System.out.println("Chua co sinh vien nao");
            }else
            {
                for(Student student: studentList)
                {
                    System.out.println(student);
                }
            }
        }catch (SQLException e)
        {
            System.out.println("Loi" + e.getMessage());
        }
        try
        {
            List<Student> studentList = std.locTheoGPA(minGpa);
            if(studentList.isEmpty())
            {
                System.out.println("Khong co sinh vien dat nguong: " + minGpa);
            }else
            {
                for (Student student: studentList)
                {
                    System.out.println(student);
                }
            }
        }catch (SQLException e)
        {
            System.out.println("Loi"+ e.getMessage());
        }
    }
}
