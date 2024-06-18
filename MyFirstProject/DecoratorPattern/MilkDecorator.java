package DecoratorPattern;

public class MilkDecorator extends CoffeeDecorator{

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public int cost() {
        return 1;
    }
}
