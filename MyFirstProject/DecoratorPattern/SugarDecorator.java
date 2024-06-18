package DecoratorPattern;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int cost() {
        return 2;
    }
}
