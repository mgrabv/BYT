//Concrete class 1:

public class CheesyCheeseburger extends Sandwich {

    @Override
    void addMeat() {
        System.out.println("Adding 1 burger meatpatty...");
    }

    @Override
    void addCheese() {
        System.out.println("Adding 5 slices of American Cheese...");
    }

    @Override
    void addVegetablesAndFruits() {
        System.out.println("Adding onions, salad, tomatoes and pickles");
    }

    @Override
    void addHotSauce() {
        System.out.println("Adding some Hot Sauce...");
    }

    @Override
    void addMildSauce() {
        System.out.println("Adding some Mild Sauce...");   
    }
    
}
