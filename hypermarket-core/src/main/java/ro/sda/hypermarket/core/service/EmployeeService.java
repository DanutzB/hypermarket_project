package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Employee;

public interface EmployeeService {

    void createEmployee(Employee employee, boolean useHibernate);

    Employee readEmployee(Long employeeId, boolean useHibernate);

    Employee updateEmployee(Employee employee, boolean useHibernate);

    void deleteEmployee(Long employeeId, boolean useHibernate);

}
