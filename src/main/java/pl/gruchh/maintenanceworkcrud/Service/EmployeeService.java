package pl.gruchh.maintenanceworkcrud.Service;

import org.springframework.stereotype.Service;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    boolean saveNewWorkOrder(Employee newEmployee);
    List<Employee> getAllWorkOrders();
    void deleteWorkOrder(Long id);
    void updateWorkOrder(Employee workOrder);
    Employee findWorkOrderById(Long id);

}
