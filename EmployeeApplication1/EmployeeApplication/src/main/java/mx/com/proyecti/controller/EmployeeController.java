package mx.com.proyecti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyecti.entity.Employee;
import mx.com.proyecti.service.EmployeeService;

//Define a mi clase dentro del contexto de un Spring como una clase dentro de la capa controlador.
//y ademas define mis puntos de entrada o endpoint de mi servicio REST
//con @RestController estoy haciendo uso del modulo de Spring MVC

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("api")
public class EmployeeController {
	
	
	//busca dentro de las implementaciones aquella que implemente la interfaz EmployeeService
	//en este caso la clase que incrementa EmployeeService es EmployeeServiceImpl
	@Autowired
	EmployeeService employeeService;
	
	//GET, POST, PUT, DELETE
	
	@GetMapping("/employees")//GET
	List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}
	@PostMapping("/employees")//POST
	Integer insertEmployee(@RequestBody Employee employee) {//@RequestBody define parametros de entrada dentro del cuerpo del mensaje
		return employeeService.insertEmployee(employee);
	}
	
	@GetMapping("/employees/{id}")
	Employee getEmployee(@PathVariable Integer id) {//@PathVariable me permite definir un dato de entrada dentro de la URL de mi operacion
		return employeeService.getEmployee(id);
	}
	@PutMapping("/employees") //PUT
	Boolean updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	@DeleteMapping("/employee/{id}")
	Boolean deleteEmployee(@PathVariable Integer id) {
		return employeeService.deleteEmployee(id);
	}
	
	

}
