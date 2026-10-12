package org.example;

public class Main {
    static void main(String[] args) {
        StudentDAO std = new StudentDAO();
        Student s = std.findById("131");
        if(s!=null)
        {
            System.out.println("da tim thay sinh vien " + s.getId());
        }else
        {
            System.out.println("Khong ton tai id ");
        }
    }
}
