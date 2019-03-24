package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.repository.EmployeeRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee, boolean useHibernate) {
        if (useHibernate) {
            employeeDAO.createEmployee(employee);
        }
        employeeRepository.save(employee);
    }

    @Override
    public Employee readEmployee(Long employeeId, boolean useHibernate) {
        if (useHibernate) {
            return employeeDAO.readEmployee(employeeId);
        }
        return employeeRepository.findById(employeeId);
    }

    @Override
    public Employee updateEmployee(Employee employee, boolean useHibernate) {
        if (useHibernate) {
            return employeeDAO.updateEmployee(employee);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId, boolean useHibernate) {
        if (useHibernate) {
            employeeDAO.deleteEmployee(employeeId);
        }
        employeeRepository.delete(employeeId);
    }

}
