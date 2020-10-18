package mx.com.proyecti;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mx.com.proyecti.entity.Employee;

public class EmployeeManager {
	public SessionFactory sessionFactory;
	
	public void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()//configura opciones dentro de hibernate.cfg.xml
				.build();//Implementa el patrón builder
		
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public void exit() {
		sessionFactory.close();
	}
	
	public int create(String firstName, String lastName, Date birthdate, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setBirthdate(birthdate);
		employee.setSalary(salary);
		
		Session session = sessionFactory.openSession();
		//Iniciar una transaccion
		session.beginTransaction();
		Integer id = (Integer) session.save(employee);//Insert
		session.getTransaction().commit();
		
		session.close();
		
		return id;
		
	}
	
	public Employee read(Integer id) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, id);
		
		session.close();
		
		return employee;
		
	}
	
	public void update(Integer id, String firstName, String lastName, Date birthdate, double salary) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setBirthdate(birthdate);
		employee.setSalary(salary);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(employee);//SQL:UPDATE
		
		session.getTransaction().commit();//confirmar el update
		session.close();
	}
	
	public void delete(Integer id) {
		Employee employee = new Employee();
		employee.setId(id);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(employee);//SQL:DELETE
		
		session.getTransaction().commit();
		session.close();
	}
//TODO: Implementar el metodo readAll
	
	public List<Employee> readAll(){
		Session session=sessionFactory.openSession();
		List<Employee> list = session.createQuery("from Employee").list();
		return list;
	}
	
}
