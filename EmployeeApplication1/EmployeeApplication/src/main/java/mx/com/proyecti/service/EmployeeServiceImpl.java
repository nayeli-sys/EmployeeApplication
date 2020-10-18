package mx.com.proyecti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.proyecti.entity.Employee;
import mx.com.proyecti.repository.EmployeeRepository;

//La capa service nos sirve para implementar el patron de diseño "Separacion de intereses" o "Separation of concerns"
//Describir la logica de negocio de nuestra aplicacion
//incluye el acceso a los repositorios

public class EmployeeServiceImpl implements EmployeeService{

	//Scopes de Spring:
		//--Singleton: se genera una unica instancia y este es el scope por default
		//--Prototype se genera una instancia cada que yo requiera una referencia al objecto
	//IoT ("Inversion of control" o "inversion de control")
	//Inyeccion de dependencias: En tiempo de ejecucion Sprint va a inicializar nuestros objectos
	@Autowired //AutoCambiado, Spring toma el control de la inicializacion de mi objecto y lo crea de forma automatica
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(Integer id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public Integer insertEmployee(Employee employee) {
		return employeeRepository.save(employee).getId();
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		Employee emp = employeeRepository.findOne(employee.getId());
		if(emp != null) {
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setBirthdate(employee.getBirthdate());
			emp.setSalary(employee.getSalary());
			employeeRepository.save(emp);
			return true;
			
		}else return false;
	}

	@Override
	public Boolean deleteEmployee(Integer id) {
		employeeRepository.delete(id);
		return true;
	}
	
	

}
