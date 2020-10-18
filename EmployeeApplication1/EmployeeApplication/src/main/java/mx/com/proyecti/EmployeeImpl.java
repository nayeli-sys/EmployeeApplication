package mx.com.proyecti;

import mx.com.proyecti.entity.Employee;

public class EmployeeImpl {

	public static void main(String[] args) {
		EmployeeManager manager = new EmployeeManager();
		manager.setup();
		
		Employee employee = manager.read(1);
		System.out.println("Empleado: " + employee.getFirstName() + " " + employee.getLastName() );
		
		manager.exit();

	}

}
