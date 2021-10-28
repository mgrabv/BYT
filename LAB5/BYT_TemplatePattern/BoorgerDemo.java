//Demo for the Template Pattern:

public class BoorgerDemo {
    
    public static void main(String[] args) {
        System.out.println("----------------Customer1 Order----------------");
        CheesyCheeseburger customer1 = new CheesyCheeseburger();
        customer1.makeSandwich();

        System.out.println();

        System.out.println("----------------Customer2 Order----------------");
        HotVeggieBurger customer2 = new HotVeggieBurger();
        customer2.makeSandwich();

        System.out.println();

        System.out.println("----------------Customer3 Order----------------");
        DoubleTroubleMildBurger customer3 = new DoubleTroubleMildBurger();
        customer3.makeSandwich();

        System.out.println();
    }
}
