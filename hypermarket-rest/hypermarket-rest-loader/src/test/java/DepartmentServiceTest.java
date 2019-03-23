import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.dao.DepartmentDAO;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.service.DepartmentService;
import ro.sda.hypermarket.core.service.EmployeeService;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;
    @Test
    public void testCreate(){
        Employee employee = new Employee();
        employee.setFirstName("Florinn");
        employee.setLastName("Izmanaaa");
        employee.setCity("Iasiii");
        employee.setJobTitle("soferrr");
        employee.setSalary(40000);
        employeeService.createEmployee(employee);

        Department department = new Department();
        department.setName("Drinks");
        department.setManager(employee);
        departmentService.createDepartment(department);
        Assert.assertNotNull(department);
    }

    @Test
    public void readDepartment(){
        Department dep = departmentService.readDepartment(1L);
        Long actual = dep.getId();
        Long expected = 1L;
        System.out.println(dep.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateDepartment(){
        Department dep = departmentService.readDepartment(1L);
        System.out.println("Update:" + dep);
        dep.setName("dairy_products");

        departmentService.updateDepartment(dep);
        System.out.println(dep);
    }

    @Test
    public void deleteDepartment() {
        Department dep = departmentService.deleteDepartment(1L);
        Assert.assertNotNull(dep);

    }

}
