package DecoratorPattern;

public abstract class CoffeeDecorator implements Coffee{
    private Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
