public class AccessingAnEmptyStackCheckedException extends Exception{
    public AccessingAnEmptyStackCheckedException(String errorMessage) {
        super(errorMessage);
    }
    public AccessingAnEmptyStackCheckedException() {
        super("AccessingAnEmptyStackCheckedException");
    }
}
