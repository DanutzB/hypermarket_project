import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.service.EmployeeService;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    @Rollback(false)
    public void testCreate(){
        Employee employee = new Employee();
        employee.setFirstName("Florin");
        employee.setLastName("Izmana");
        employee.setCity("Iasi");
        employee.setJobTitle("sofer");
        employee.setSalary(4000);
        employeeService.createEmployee(employee, false);
        Assert.assertNotNull(employee);
    }

    @Test
    @Rollback(false)
    public void readEmployee(){
        Employee emp = employeeService.readEmployee(2L, false);
        Long actual = emp.getId();
        Long expected = 2L;
        System.out.println(emp.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void updateEmployee(){
        Employee emp = employeeService.readEmployee(1L, false);
        System.out.println("Update:" + emp);
        emp.setFirstName("Toyota");
        emp.setLastName("kamasutra");
        emp.setCity("Suceava");
        employeeService.updateEmployee(emp, false);
        System.out.println(emp);
    }

    @Test
    @Rollback(false)
    public void deleteEmployee() {
        employeeService.deleteEmployee(4L, false);

    }


}
