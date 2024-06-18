package MyFirstPackage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Student st = new Student();
        // st.close();
        st.writeToFile("Hello world 1");
        st.close();
        st.writeToFile("Hello world 2");
    }
}
