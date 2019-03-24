package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Employee;

public interface EmployeeDAO {

    void createEmployee(Employee employee);

    Employee readEmployee(Long employeeId);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long employeeId);
}
