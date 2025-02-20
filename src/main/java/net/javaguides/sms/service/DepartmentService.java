package net.javaguides.sms.service;

import java.util.List;
import net.javaguides.sms.entity.Department;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department saveDepartment(Department department);
    Department getDepartmentById(Long id);
    Department updateDepartment(Department department);
    void deleteDepartmentById(Long id);
}
