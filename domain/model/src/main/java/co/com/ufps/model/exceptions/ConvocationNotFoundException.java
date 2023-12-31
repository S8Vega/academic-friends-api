package co.com.ufps.model.exceptions;

public class ConvocationNotFoundException extends RuntimeException {
    public ConvocationNotFoundException(String message) {
        super(message);
    }

    public ConvocationNotFoundException(RuntimeException e) {
        super(e);
    }
}
