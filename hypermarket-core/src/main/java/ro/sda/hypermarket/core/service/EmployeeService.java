package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Employee;

public interface EmployeeService {
    void createEmployee(Employee employee);

    Employee readEmployee(Long employeeId);

    void updateEmployee(Employee employee);

    Employee deleteEmployee(Long employeeId);

}
