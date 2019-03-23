import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDAO;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.dao.SaleDAO;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.Sale;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SaleServiceTest {

    @Autowired
    private SaleDAO saleDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Test
    public void testCreate(){
        Employee employee = new Employee();
        employee.setFirstName("Apetri");
        employee.setLastName("George");
        employee.setCity("Iasi");
        employee.setJobTitle("sofer");
        employee.setSalary(4000);
        employeeDAO.createEmployee(employee);

        Client client = new Client();
        client.setName("Cristache");
        clientDAO.createClient(client);

        Sale sale = new Sale();
        sale.setClientId(client);
        sale.setEmployeeId(employee.getId());
        sale.setPurchaseNumber(1234L);
        sale.setPurchaseValue(4545L);
        saleDAO.createSale(sale);
        Assert.assertNotNull(sale);
    }
    @Test
    public void testRead() {
        Sale sale = saleDAO.readSale(1L);
        Long actual = sale.getId();
        Long expected = 1L;
        System.out.println(sale.toString());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setFirstName("Georgescu");
        employee.setLastName("Bogdan");
        employee.setCity("Oradea");
        employee.setJobTitle("vanzator");
        employee.setSalary(3000);
        employeeDAO.createEmployee(employee);

        Client client = new Client();
        client.setName("Chiorecu");
        clientDAO.createClient(client);

        Sale sale = saleDAO.readSale(1L);
        System.out.println("Update " + sale + " to:");
        sale.setPurchaseValue(6666L);
        sale.setPurchaseNumber(667788L);
        sale.setEmployeeId(employee.getId());
        sale.setClientId(client);

        saleDAO.updateSale(sale);
        Sale expected = saleDAO.readSale(1L);
        Sale actual = sale;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDelete() {
        Sale sale = saleDAO.readSale(1L);
        saleDAO.deleteSale(sale);
        Assert.assertNotNull(sale);
    }
}
