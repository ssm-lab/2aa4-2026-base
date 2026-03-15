package FluentAPI.pizza;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza p1 = new PizzaBuilder()
            .size(Size.LARGE).crust(Crust.THIN).sauce(Sauce.RED)
            .addTopping("cheese").addTopping("pepperoni").addTopping("mushrooms")
            .build();

        Pizza p2 = new PizzaBuilder()
            .size(Size.SMALL).crust(Crust.STUFFED).sauce(Sauce.PESTO)
            .addTopping("spinach").addTopping("feta")
            .build();

        Pizza p3 = new PizzaBuilder()
            .size(Size.MEDIUM).crust(Crust.THICK).sauce(Sauce.WHITE)
            .addTopping("chicken")
            .build();

        for (Pizza p : new Pizza[]{p1, p2, p3}) {
            System.out.println(p + " | Price: $" + p.price());
        }
    }
}
