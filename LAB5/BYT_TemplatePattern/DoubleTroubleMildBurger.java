//Concrete class 3:

public class DoubleTroubleMildBurger extends Sandwich {

    boolean customerWantsHotSauce = false;

    @Override
    void addMeat() {
        System.out.println("Adding 2 burger meatpatties...");
    }

    @Override
    void addCheese() {
        System.out.println("Adding 2 slices of American Cheese...");
    }

    @Override
    void addVegetablesAndFruits() {
        System.out.println("Adding onions, salad, tomatoes and pickles");
    }

    @Override
    void addHotSauce() {}

    @Override
    void addMildSauce() {
        System.out.println("Adding some Mild Sauce...");
    }
    
}
