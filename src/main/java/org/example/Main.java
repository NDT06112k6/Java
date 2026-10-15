package org.example;

import java.sql.SQLException;

public class Main {
    static void main(String[] args) {
        StudentDAO std = new StudentDAO();
        String id = "135";
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
    }
}
