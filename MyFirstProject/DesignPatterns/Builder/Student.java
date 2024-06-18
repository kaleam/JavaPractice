package DesignPatterns.Builder;

public class Student {
    private String name;
    private int age;
    private String batch;
    private Double psp;

    public static Builder getBuilder() {
        return new Builder();
    }

    private Student(Builder builder) {
        this.name = builder.name;
        this.batch = builder.batch;
        this.psp = builder.psp;
        this.age = builder.age;
    }

    public String getName() {
        return this.name;
    }

    public String getBatch() {
        return this.batch;
    }

    public int getAge() {
        return this.age;
    }

    public double getPSP() {
        return this.psp;
    }

    public static class Builder {
        private String name;
        private int age;
        private String batch;
        private Double psp;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setPSP(Double psp) {
            this.psp = psp;
            return this;
        }

        public Student Build() {
            // validations
            return new Student(this);
        }
    }
}
