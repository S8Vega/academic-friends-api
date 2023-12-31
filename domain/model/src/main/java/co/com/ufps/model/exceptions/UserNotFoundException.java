package co.com.ufps.model.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(RuntimeException e) {
        super(e);
    }
}
