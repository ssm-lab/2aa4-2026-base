package FluentAPI.pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private Size size;
    private Crust crust;
    private Sauce sauce;
    private final List<String> toppings = new ArrayList<>();

    public PizzaBuilder size(Size size) { this.size = size; return this; }
    public PizzaBuilder crust(Crust crust) { this.crust = crust; return this; }
    public PizzaBuilder sauce(Sauce sauce) { this.sauce = sauce; return this; }
    public PizzaBuilder addTopping(String topping) { toppings.add(topping); return this; }

    public Pizza build() { return new Pizza(size, crust, sauce, toppings); }
}