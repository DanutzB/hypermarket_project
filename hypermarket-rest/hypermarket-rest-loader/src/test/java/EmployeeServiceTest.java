import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.entity.Employee;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class EmployeeServiceTest {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Test
    public void testCreate(){
        Employee employee = new Employee();
        employee.setFirstName("Florin");
        employee.setLastName("Izmana");
        employee.setCity("Iasi");
        employee.setJobTitle("sofer");
        employee.setSalary(4000);
        employeeDAO.createEmployee(employee);
        Assert.assertNotNull(employee);
    }

    @Test
    public void readEmployee(){
        Employee emp = employeeDAO.readEmployee(1L);
        Long actual = emp.getId();
        Long expected = 1L;
        System.out.println(emp.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateEmployee(){
        Employee emp = employeeDAO.readEmployee(1L);
        System.out.println("Update:" + emp);
        emp.setFirstName("Toyota");
        emp.setLastName("kamasutra");
        emp.setCity("Suceava");
        employeeDAO.updateEmployee(emp);
        System.out.println(emp);
    }

    @Test
    public void deleteEmployee() {
        Employee emp = employeeDAO.deleteEmployee(1L);
        Assert.assertNotNull(emp);

    }


}
