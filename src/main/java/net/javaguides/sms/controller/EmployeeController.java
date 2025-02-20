package net.javaguides.sms.controller;

import net.javaguides.sms.entity.Employee;
import net.javaguides.sms.entity.Department;
import net.javaguides.sms.service.EmployeeService;
import net.javaguides.sms.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }
    
    @GetMapping("/employees/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee()); // Empty form
        model.addAttribute("departments", departmentService.getAllDepartments()); // Pass department list
        return "employees/add-employee"; // Must match the Thymeleaf file path
    }


    // ✅ 1. LIST ALL EMPLOYEES
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";  // Ensure "employees.html" exists in templates
    }

    // ✅ 2. SHOW ADD EMPLOYEE FORM
    @GetMapping("/new")
    public String showEmployeeForm(Model model) {
        Employee employee = new Employee();
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments); // Provide departments for dropdown
        return "add-employee"; // Ensure "add-employee.html" exists
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        if (employee.getDepartment() == null || employee.getDepartment().getId() == null) {
            System.out.println("Error: Department is null!");
            return "redirect:/employees/new?error=DepartmentRequired"; // Redirect with error message
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }


    // ✅ 4. SHOW EDIT EMPLOYEE FORM
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return "redirect:/employees"; // Redirect if employee is not found
        }
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "edit_employee"; // Ensure "edit-employee.html" exists in templates
    }

    // ✅ 5. UPDATE EMPLOYEE
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee updatedEmployee) {
        employeeService.updateEmployee(id, updatedEmployee);
        return "redirect:/employees"; // Redirect to employee list after update
    }

    // ✅ 6. DELETE EMPLOYEE
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees"; // Redirect to updated list after deletion
    }
}
