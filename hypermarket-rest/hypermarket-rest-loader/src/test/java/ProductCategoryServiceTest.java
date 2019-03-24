import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.ProductCategory;
import ro.sda.hypermarket.core.service.EmployeeService;
import ro.sda.hypermarket.core.service.ProductCategoryService;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ProductCategoryServiceTest {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private EmployeeService employeeService;

    @Test
    @Rollback(false)
    public void testCreate(){
        Employee employee = new Employee();
        employee.setFirstName("Irinel");
        employee.setLastName("Vucic");
        employee.setCity("Iasi");
        employee.setJobTitle("salesman");
        employee.setSalary(25000);
        employeeService.createEmployee(employee,false);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("cleaning_products");
        productCategory.setManager(employee);
        productCategoryService.createProductCategory(productCategory, false);
        Assert.assertNotNull(productCategory);
    }

    @Test
    @Rollback(false)
    public void readProductCategory(){
        ProductCategory prodCat = productCategoryService.readProductCategory(1L, false);
        Long actual = prodCat.getId();
        Long expected = 1L;
        System.out.println(prodCat.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void updateProductCategory(){
        Employee employee = new Employee();
        employee.setFirstName("Doru");
        employee.setLastName("Iordache");
        employee.setCity("Iasi");
        employee.setJobTitle("assistent");
        employee.setSalary(28000);
        employeeService.createEmployee(employee, false);

        ProductCategory prodCat = productCategoryService.readProductCategory(1L, false);
        System.out.println("Update:" + prodCat);
        prodCat.setName("electronics");
        prodCat.setManager(employee);
        productCategoryService.updateProductCategory(prodCat, false);
        System.out.println(prodCat);
    }

    @Test
    @Rollback(false)
    public void deleteProductCategory() {
        productCategoryService.deleteProductCategory(1L, false);
        ProductCategory fromdb = productCategoryService.readProductCategory(1L, false);
        Assert.assertNull(fromdb);

    }

}
