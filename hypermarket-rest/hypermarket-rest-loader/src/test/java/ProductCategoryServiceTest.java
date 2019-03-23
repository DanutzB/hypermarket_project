import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.dao.ProductCategoryDAO;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.ProductCategory;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ProductCategoryServiceTest {

    @Autowired
    private ProductCategoryDAO productCategoryDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void testCreate(){
        Employee employee = new Employee();
        employee.setFirstName("Irinel");
        employee.setLastName("Vucic");
        employee.setCity("Iasi");
        employee.setJobTitle("salesman");
        employee.setSalary(25000);
        employeeDAO.createEmployee(employee);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("cleaning_products");
        productCategory.setManager(employee);
        productCategoryDAO.createProductCategory(productCategory);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void readProductCategory(){
        ProductCategory prodCat = productCategoryDAO.readProductCategory(1L);
        Long actual = prodCat.getId();
        Long expected = 1L;
        System.out.println(prodCat.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateProductCategory(){
        Employee employee = new Employee();
        employee.setFirstName("Doru");
        employee.setLastName("Iordache");
        employee.setCity("Iasi");
        employee.setJobTitle("assistent");
        employee.setSalary(28000);
        employeeDAO.createEmployee(employee);

        ProductCategory prodCat = productCategoryDAO.readProductCategory(1L);
        System.out.println("Update:" + prodCat);
        prodCat.setName("electronics");
        prodCat.setManager(employee);
        productCategoryDAO.updateProductCategory(prodCat);
        System.out.println(prodCat);
    }

    @Test
    public void deleteProductCategory() {
        ProductCategory prodCat = productCategoryDAO.deleteProductCategory(1L);
        Assert.assertNotNull(prodCat);

    }

}
