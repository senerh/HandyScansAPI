package exception;

import javax.ejb.EJBException;

public class ShonenTouchGenericException extends EJBException {

    private static final long serialVersionUID = 89097219215287167L;

    public ShonenTouchGenericException(String message) {
        super(message);
    }

    public ShonenTouchGenericException(String message, Exception cause) {
        super(message, cause);
    }
}
