package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Department;

public interface DepartmentService {
    void createDepartment(Department department);

    Department readDepartment(Long departmentId);

    void updateDepartment(Department department);

    Department deleteDepartment(Long departmentId);
}
