package MyFirstPackage;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Student extends Object {
    String name;
    static int age;
    final String batch = "May24";
    FileWriter fw;
    PrintWriter pw;
    // double psp;

    Student() throws IOException {
        fw = new FileWriter("./Student.log");
        pw = new PrintWriter(fw);
    }

    Student(String name, int age, String batch, double psp) {
        this.name = name;
        // age = age;
        // this.batch = batch;
        // this.psp = psp;
    }

    void display() {
        System.out.println("My name is " + this.name + ". I am " + age + " years old");
    }

    void writeToFile(String message) {
        if (pw == null || pw.checkError())
            throw new IllegalStateException("PrintWriter is closed");
        pw.print(message);
    }

    void close() {
        pw.close();
    }
}
