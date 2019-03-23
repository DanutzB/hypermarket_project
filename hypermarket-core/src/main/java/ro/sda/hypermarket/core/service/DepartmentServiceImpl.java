package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.DepartmentDAO;
import ro.sda.hypermarket.core.entity.Department;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDAO departmentDAO;


    @Override
    public void createDepartment(Department department) {
        departmentDAO.createDepartment(department);
    }

    @Override
    public Department readDepartment(Long departmentId) {
        return departmentDAO.readDepartment(departmentId);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDAO.updateDepartment(department);
    }

    @Override
    public Department deleteDepartment(Long departmentId) {
        return departmentDAO.deleteDepartment(departmentId);
    }


}
