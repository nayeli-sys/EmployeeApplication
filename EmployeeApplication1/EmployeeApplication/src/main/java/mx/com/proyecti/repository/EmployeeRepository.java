package mx.com.proyecti.repository;


//uso de spring con el modulo Spring Data
import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.proyecti.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}
