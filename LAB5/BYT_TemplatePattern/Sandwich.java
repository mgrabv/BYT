// Template Method Pattern:
// An abstract class contains a method that provides the steps of the algorithm.
// It allows subclasses (concrete classes) to override some of the methods.

//Abstract class Sandwich:
public abstract class Sandwich {

    //Final method containing an algorithm:
    final void makeSandwich() {
        cutBun();

        if (customerWantsMeat) {
            addMeat();
        }

        if (customerWantsCheese) {
            addCheese();
        }

        if (customerWantsVegetablesAndFruits) {
            addVegetablesAndFruits();
        }

        if (customerWantsHotSauce) {
            addHotSauce();
        }

        if (customerWantsMildSauce) {
            addMildSauce();
        }

        wrapSandwich();
    }

    //Steps of algorithm that cannot be in concrete classes changed:
    final void cutBun() {
        System.out.println("Cutting buns for the sandwich...");
    }

    final void wrapSandwich() {
        System.out.println("Wrapping the sandwich for the customer...");
    }

    //So called "hooks", properties that may be changed in concrete classes.
    boolean customerWantsMeat = true;
    boolean customerWantsCheese = true;
    boolean customerWantsVegetablesAndFruits = true;
    boolean customerWantsHotSauce = true;
    boolean customerWantsMildSauce = true;

    //Abstract methods (steps of the algorithm) which must be implemented in concrete classes:
    abstract void addMeat();
    abstract void addCheese();
    abstract void addVegetablesAndFruits();
    abstract void addHotSauce();
    abstract void addMildSauce();
}