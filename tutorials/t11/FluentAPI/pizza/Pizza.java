package FluentAPI.pizza;

import java.util.List;

public class Pizza {
    private final Size size;
    private final Crust crust;
    private final Sauce sauce;
    private final List<String> toppings;

    public Pizza(Size size, Crust crust, Sauce sauce, List<String> toppings) {
        this.size = size; this.crust = crust;
        this.sauce = sauce; this.toppings = toppings;
    }

    public double price() {
        double base = switch (size) { case SMALL -> 8.0; case MEDIUM -> 11.0; case LARGE -> 14.0; };
        return base + toppings.size() * 1.50;
    }

    @Override
    public String toString() {
        return size + " pizza | " + crust + " crust | " + sauce + " sauce"
             + " | Toppings: " + toppings;
    }
}