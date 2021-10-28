//Demo for the Chain of Responsibility Pattern.

public class CalculatorDemo {
    
    public static void main(String[] args) {
        Middleware add = new Addition();
        Middleware sub = new Subtraction();
        Middleware mul = new Multiplication();
        Middleware div = new Division();

        add.setNextMiddleware(sub);
        sub.setNextMiddleware(mul);
        mul.setNextMiddleware(div);

        Request request = new Request(10, 2, "divide");
        add.calculate(request);
    }
}