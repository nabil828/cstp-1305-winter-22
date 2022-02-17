public class AddingIntoFullADTCheckedException extends Exception{
    public AddingIntoFullADTCheckedException(String errorMessage) {
        super(errorMessage);
    }
    public AddingIntoFullADTCheckedException() {
        super("AddingIntoFullADTCheckedException");
    }
}