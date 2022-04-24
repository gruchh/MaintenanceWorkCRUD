package pl.gruchh.maintenanceworkcrud.Exception;

public class EmployeeNameAndSurnameChanged extends RuntimeException {

    private String message;

    public EmployeeNameAndSurnameChanged(String message) {
        super(message);
        this.message = message;
    }

    public EmployeeNameAndSurnameChanged() {
    }
}
