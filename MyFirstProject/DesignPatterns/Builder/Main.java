package DesignPatterns.Builder;

import DesignPatterns.Builder.Student.Builder;

public class Main {
    public static void main(String[] args) {
        Builder b = Student.getBuilder();
        b.setName("Abhijeet").setAge(33).setBatch("May23").setPSP(97.9);
        Student st = b.Build();
        System.out.println(st.getName());
    }
}
