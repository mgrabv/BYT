public interface Middleware {

    public void setNextMiddleware(Middleware next);

    public void calculate(Request request);
}