package MyFirstPackage;

public class Main {
    public static void main(String[] args) {
        // Student st1 = new Student("Abhijeet", 33, "May23", 94.50);
        // System.out.println(
        // "Student " + st1.name + " of age " + st1.age + " is in batch " + st1.batch +
        // " with psp " + st1.psp);
        // System.out.println("Main thread 1");
        // Student st = new Student();
        // Thread t = new Thread(st);
        // t.start();
        // System.out.println("Main thread 2: " + Thread.currentThread().getName());

        Student s1 = new Student();
        s1.age = 10;
        s1.name = "A";

        Student s2 = new Student();
        s2.age = 20;
        s2.name = "B";

        s1 = swap(s1, s2);

        s1.display();
    }

    private static Student swap(Student s1, Student s2) {
        Student temp = s1;
        temp.display();
        s1 = s2;
        s1.display();
        s2 = temp;
        s2.display();

        return s1;
    }
}
