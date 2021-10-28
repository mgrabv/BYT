//Concrete class 2:

public class HotVeggieBurger extends Sandwich {

    boolean customerWantsMeat = false;
    boolean customerWantsCheese = false;
    boolean customerWantsMildSauce = false;

    @Override
    void addMeat() {}

    @Override
    void addCheese() {}

    @Override
    void addVegetablesAndFruits() {
        System.out.println("Adding 1 burger veggiepatty and additional vegetables " +
                           "covered with vegan cheese...");
    }

    @Override
    void addHotSauce() {
        System.out.println("Adding some Hot Sauce...");
    }

    @Override
    void addMildSauce() {}
}
