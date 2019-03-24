package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.DepartmentDAO;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.repository.DepartmentRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department createDepartment(Department department, boolean useHibernate) {
        if(useHibernate){
            return  departmentDAO.createDepartment(department);
        }
            return departmentRepository.save(department);
    }

    @Override
    public Department readDepartment(Long departmentId, boolean useHibernate) {
        if(useHibernate){
            return departmentDAO.readDepartment(departmentId);
        }
        return departmentRepository.findById(departmentId);
    }

    @Override
    public Department updateDepartment(Department department, boolean useHibernate) {
        if(useHibernate){
            return departmentDAO.updateDepartment(department);
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department deleteDepartment(Long departmentId, boolean useHibernate) {
        if(useHibernate){
            departmentDAO.deleteDepartment(departmentId);
        }
            departmentRepository.delete(departmentId);
        return null;
    }


}
