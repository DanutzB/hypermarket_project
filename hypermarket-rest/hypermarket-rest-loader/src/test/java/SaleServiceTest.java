import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.Sale;
import ro.sda.hypermarket.core.service.ClientService;
import ro.sda.hypermarket.core.service.EmployeeService;
import ro.sda.hypermarket.core.service.SaleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SaleServiceTest {

    @Autowired
    private SaleService saleService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ClientService clientService;

    @Test
    @Rollback(false)
    public void testCreate(){
        Employee employee = new Employee();
        employee.setFirstName("Apetri");
        employee.setLastName("George");
        employee.setCity("Iasi");
        employee.setJobTitle("sofer");
        employee.setSalary(4000);
        employeeService.createEmployee(employee, false);

        Client client = new Client();
        client.setName("Cristache");
        clientService.createClient(client, false);

        Sale sale = new Sale();
        sale.setClientId(client);
        sale.setEmployeeId(employee.getId());
        sale.setPurchaseNumber(1234L);
        sale.setPurchaseValue(4545L);
        saleService.createSale(sale, false);
        Assert.assertNotNull(sale);
    }
    @Test
    @Rollback(false)
    public void testRead() {
        Sale sale = saleService.readSale(1L, false);
        Long actual = sale.getId();
        Long expected = 1L;
        System.out.println(sale.toString());
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Rollback(false)
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setFirstName("Georgescu");
        employee.setLastName("Bogdan");
        employee.setCity("Oradea");
        employee.setJobTitle("vanzator");
        employee.setSalary(3000);
        employeeService.createEmployee(employee, false);

        Client client = new Client();
        client.setName("Chiorecu");
        clientService.createClient(client, false);

        Sale sale = saleService.readSale(1L, false);
        System.out.println("Update " + sale + " to:");
        sale.setPurchaseValue(6666L);
        sale.setPurchaseNumber(667788L);
        sale.setEmployeeId(employee.getId());
        sale.setClientId(client);

        saleService.updateSale(sale, false);
        Sale expected = saleService.readSale(1L, false);
        Sale actual = sale;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Rollback(false)
    public void testDelete() {
        Sale sale = saleService.readSale(1L, false);
        saleService.deleteSale(sale, false);
        Assert.assertNotNull(sale);
    }
}
