package org.example;

import java.sql.SQLException;

public class Main {
    static void main(String[] args) {
        StudentDAO std = new StudentDAO();

        try{
            Student s = std.findById("131");
            if(s!=null)
            {
                System.out.println("da tim thay sinh vien " + s.getId());
            }else
            {
                System.out.println("Khong ton tai id ");
            }
        }catch (SQLException e)
        {
            System.out.println("Loi " + e.getMessage());
        }
    }
}
