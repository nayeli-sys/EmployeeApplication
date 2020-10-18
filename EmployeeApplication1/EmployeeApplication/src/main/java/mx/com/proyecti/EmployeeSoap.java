package mx.com.proyecti;

import java.sql.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import mx.com.proyecti.entity.Employee;

@WebService
public class EmployeeSoap {
	
	public final String hello = "Hola Mundo";
	EmployeeManager manager = new EmployeeManager();
	public EmployeeSoap() {
		
	}
	
	//Metodo es llamado "operacion"
	public String getHello(@WebParam(name="nombre") String name) {
		return hello + " " + name;
	}
	
	@WebMethod
	public Integer create(@WebParam(name="firstname") String firstName,
			@WebParam(name="lastname") String lastName,
			@WebParam(name="birthdate") Date birthdate,
			@WebParam(name="salary") double salary) {
		manager.setup();
		Integer id = manager.create(firstName, lastName, birthdate, salary);
		manager.exit();
		return id;
	}
	
	@WebMethod
	public Employee read(@WebParam (name="id") Integer id) {
		manager.setup();
		Employee employee = manager.read(id);
		manager.exit();
		return employee;
				
	}
	
	@WebMethod
	public List<Employee> redAll(){
		manager.setup();
		List<Employee> employee = manager.readAll();
		manager.exit();
		return employee;
	}
	
	@WebMethod
	public Boolean update(@WebParam (name="id") Integer id,
			@WebParam(name="firstname") String firstName,
			@WebParam(name="lastname") String lastName,
			@WebParam(name="birthdate") Date birthdate,
			@WebParam(name="salary") double salary) {
		manager.setup();
		manager.update(id, firstName, lastName, birthdate, salary);
		manager.exit();
		return true;
	}
	
	@WebMethod
	public Boolean delete(@WebParam(name="id")Integer id) {
		manager.setup();
		manager.delete(id);
		manager.exit();
		return true;
	}

}
