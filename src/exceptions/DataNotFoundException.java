package exceptions;

public class DataNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;  // ✅ Add this line

    public DataNotFoundException(String msg) {
        super(msg);
    }
}
