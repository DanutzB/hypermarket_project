package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Department;

public interface DepartmentService {

    Department createDepartment(Department department, boolean useHibernate);

    Department readDepartment(Long departmentId, boolean useHibernate);

    Department updateDepartment(Department department, boolean useHibernate);

    Department deleteDepartment(Long departmentId, boolean useHibernate);
}
