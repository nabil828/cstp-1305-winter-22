public class AccessingAnEmptyADTCheckedException extends Exception{
    public AccessingAnEmptyADTCheckedException(String errorMessage) {
        super(errorMessage);
    }
    public AccessingAnEmptyADTCheckedException() {
        super("AccessingAnEmptyADTCheckedException");
    }
}
