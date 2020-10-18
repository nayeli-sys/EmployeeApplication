package mx.com.proyecti.service;

import java.util.List;

import mx.com.proyecti.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee getEmployee(Integer id);
	Integer insertEmployee(Employee employee);
	Boolean updateEmployee(Employee employee);
	Boolean deleteEmployee(Integer id);
	
	

}
