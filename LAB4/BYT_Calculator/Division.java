public class Division implements Middleware {

    private Middleware next;

    @Override
    public void setNextMiddleware(Middleware next) {
        this.next = next;
    }

    @Override
    public void calculate(Request request) {
        if (request.getOperation().toUpperCase().equals("DIVIDE")) {
            if (request.getNumber2() == 0){
                System.out.println("Cannot divide by 0, change the second number...");
            }
            else{
                int result = request.getNumber1() / request.getNumber2();
                System.out.println(request.getNumber1() + " / " +
                    request.getNumber2() + " = " + result);
            }
        }
        else if (next != null) {
            next.calculate(request);
        }
        else {
            System.out.println("This calculator only works for Addition, Subtraction, Multiplication and Division.");
        }
    }
    
}
