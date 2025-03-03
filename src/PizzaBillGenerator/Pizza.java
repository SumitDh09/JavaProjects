package PizzaBillGenerator;

public class Pizza {
    private int price;

    private boolean cheeseAdded = false;
    private boolean toppingsAdded = false;
    private boolean takeAwayOpted = false;

    public Pizza(boolean veg) {
        this.price = (veg) ? 300 : 400;  // Vegetarian pizza is cheaper
    }

    public void addExtraCheese() {
        if (!cheeseAdded) {
            int extraCheesePrice = 100;
            this.price += extraCheesePrice;
            cheeseAdded = true;
            System.out.println("Extra cheese added");
        }
    }

    public void addExtraToppings() {
        if (!toppingsAdded) {
            int extraToppingPrice = 150;
            this.price += extraToppingPrice;
            toppingsAdded = true;
            System.out.println("Extra toppings added");
        }
    }

    public void takeAway() {
        if (!takeAwayOpted) {
            int backPackPrice = 20;
            this.price += backPackPrice;
            takeAwayOpted = true;
            System.out.println("Take away opted");
        }
    }

    public void getBill() {
        System.out.println("Total price: " + this.price);
    }

    public static void main(String[] args) {
        Pizza vegPizza = new Pizza(true);
        vegPizza.addExtraCheese();
        vegPizza.addExtraToppings();
        vegPizza.takeAway();
        vegPizza.getBill();

        Pizza nonVegPizza = new Pizza(false);
        nonVegPizza.addExtraCheese();
        nonVegPizza.addExtraToppings();
        nonVegPizza.takeAway();
        nonVegPizza.getBill();
    }
}
