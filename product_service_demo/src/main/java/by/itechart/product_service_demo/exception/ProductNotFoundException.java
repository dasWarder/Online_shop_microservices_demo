package by.itechart.product_service_demo.exception;

public class ProductNotFoundException extends Throwable{

    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
