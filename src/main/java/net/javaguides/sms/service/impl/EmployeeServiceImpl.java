package net.javaguides.sms.service.impl;

import net.javaguides.sms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeServiceImpl extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long departmentId); // Add this method
}
