package pl.gruchh.maintenanceworkcrud.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeAlreadyExistsException;
import pl.gruchh.maintenanceworkcrud.Exception.EmployeeNotFoundException;

public class ExceptionHandlerController {

    @ExceptionHandler(value = EmployeeAlreadyExistsException.class)
    public ResponseEntity<String> EmployeeAlreadyExistsException() {
        return new ResponseEntity<>("Employee already exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<String> EmployeeNotFoundException() {
        return new ResponseEntity<>("Employee not found", HttpStatus.CONFLICT);
    }
}
