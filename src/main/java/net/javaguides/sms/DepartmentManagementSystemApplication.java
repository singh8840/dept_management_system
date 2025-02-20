package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entity.Department;
import net.javaguides.sms.repository.DepartmentRepository;

@SpringBootApplication
public class DepartmentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DepartmentManagementSystemApplication.class, args);
	}

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Department student1 = new Department("Ramesh", "Fadatare", "ramesh@gmail.com");
		 * studentRepository.save(student1);
		 * 
		 * Department student2 = new Department("Sanjay", "Jadhav", "sanjay@gmail.com");
		 * studentRepository.save(student2);
		 * 
		 * Department student3 = new Department("tony", "stark", "tony@gmail.com");
		 * studentRepository.save(student3);
		 */
		
	}

}
