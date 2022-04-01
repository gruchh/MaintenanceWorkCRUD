package pl.gruchh.maintenanceworkcrud.Exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

    private String message;

    public EmployeeAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public EmployeeAlreadyExistsException() {
    }
}
