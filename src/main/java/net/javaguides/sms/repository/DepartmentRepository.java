package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.sms.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
