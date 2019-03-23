import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.dao.DepartmentDAO;
import ro.sda.hypermarket.core.dao.EmployeeService;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Employee;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class DepartmentServiceTest {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private EmployeeService employeeDAO;
    @Test
    public void testCreate(){
        Employee employee = new Employee();
        employee.setFirstName("Florinn");
        employee.setLastName("Izmanaaa");
        employee.setCity("Iasiii");
        employee.setJobTitle("soferrr");
        employee.setSalary(40000);
        employeeDAO.createEmployee(employee);

        Department department = new Department();
        department.setName("Drinks");
        department.setManager(employee);
        departmentDAO.createDepartment(department);
        Assert.assertNotNull(department);
    }

    @Test
    public void readDepartment(){
        Department dep = departmentDAO.readDepartment(1L);
        Long actual = dep.getId();
        Long expected = 1L;
        System.out.println(dep.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateDepartment(){
        Department dep = departmentDAO.readDepartment(1L);
        System.out.println("Update:" + dep);
        dep.setName("dairy_products");

        departmentDAO.updateDepartment(dep);
        System.out.println(dep);
    }

    @Test
    public void deleteDepartment() {
        Department dep = departmentDAO.deleteDepartment(1L);
        Assert.assertNotNull(dep);

    }

}
