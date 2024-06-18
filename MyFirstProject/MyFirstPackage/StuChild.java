package MyFirstPackage;

import java.io.IOException;

public class StuChild extends Student {

    StuChild() throws IOException {
    }

    static void print(String name) {
        System.out.println(name + " in StuChild");
    }

    static void print(int age) {
        System.out.println(age + " in StuChild");
    }
}
