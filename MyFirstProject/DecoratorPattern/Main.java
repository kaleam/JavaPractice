package DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        Coffee myCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(myCoffee.cost());
    }
}
