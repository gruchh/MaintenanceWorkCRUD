package pl.gruchh.maintenanceworkcrud.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.gruchh.maintenanceworkcrud.Controller.DTO.EmployeeDto;
import pl.gruchh.maintenanceworkcrud.Repository.Entity.Employee;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    public EmployeeDto convertEmployeeToDto(Employee employee) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(employee, EmployeeDto.class);
    }

    public Employee convertDtoToEmployee(EmployeeDto employeeDto) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(employeeDto, Employee.class);
    }
}
