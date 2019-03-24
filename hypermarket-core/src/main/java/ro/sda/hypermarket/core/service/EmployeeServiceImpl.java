package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.entity.Employee;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeServiceImpl implements ro.sda.hypermarket.core.service.EmployeeService {
    @Autowired
    private EmployeeService employeeDAO;
    @Override
    public void createEmployee(Employee employee) {
        employeeDAO.createEmployee(employee);
    }

    @Override
    public Employee readEmployee(Long employeeId) {
        return employeeDAO.readEmployee(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public Employee deleteEmployee(Long employeeId) {
        return employeeDAO.deleteEmployee(employeeId);
    }

}
