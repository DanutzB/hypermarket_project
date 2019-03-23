package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Department;


public interface DepartmentDAO {
    void createDepartment(Department department);

    Department readDepartment(Long departmentId);

    void updateDepartment(Department department);

    Department deleteDepartment(Long departmentId);

}
