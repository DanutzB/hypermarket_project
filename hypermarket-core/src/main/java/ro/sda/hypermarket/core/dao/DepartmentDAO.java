package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Department;


public interface DepartmentDAO {
    Department createDepartment(Department department);

    Department readDepartment(Long departmentId);

    Department updateDepartment(Department department);

    void deleteDepartment(Long departmentId);

}
