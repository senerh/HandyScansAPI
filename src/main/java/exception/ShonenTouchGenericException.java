package exception;

public class ShonenTouchGenericException extends RuntimeException {

    public ShonenTouchGenericException(String message) {
        super(message);
    }

    public ShonenTouchGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
