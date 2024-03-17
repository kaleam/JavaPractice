package MyFirstPackage;

public class Student extends Object {
    String name;
    static int age;
    final String batch = "May24";
    // double psp;

    Student() {

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

    @Override
    protected void finalize() {

    }
}
