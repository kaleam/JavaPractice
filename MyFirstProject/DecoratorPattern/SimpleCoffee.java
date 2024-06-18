package DecoratorPattern;

public class SimpleCoffee implements Coffee{
    @Override
    public int cost() {
        return 5;
    }
}
