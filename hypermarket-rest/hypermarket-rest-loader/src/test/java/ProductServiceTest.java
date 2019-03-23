import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.dao.EmployeeService;
import ro.sda.hypermarket.core.dao.ProductCategoryDAO;
import ro.sda.hypermarket.core.dao.ProductDAO;
import ro.sda.hypermarket.core.dao.SupplierService;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.ProductCategory;
import ro.sda.hypermarket.core.entity.Supplier;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ProductServiceTest {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private SupplierService supplierDAO;
    @Autowired
    private ProductCategoryDAO productCategoryDAO;
    @Autowired
    private EmployeeService employeeDAO;

    @Test
    public void testCreate(){
        Supplier supplier = new Supplier();
        supplier.setName("George");
        supplier.setContactNo("0751733488");
        supplier.setCity("Iasi");
        supplierDAO.createSupplier(supplier);

        Employee employee = new Employee();
        employee.setFirstName("Vasile");
        employee.setLastName("Ionescu");
        employee.setCity("Iasi");
        employee.setJobTitle("manager");
        employee.setSalary(45000);
        employeeDAO.createEmployee(employee);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("dairy");
        productCategory.setManager(employee);
        productCategoryDAO.createProductCategory(productCategory);

        Product product = new Product();
        product.setName("lapte");
        product.setSupplierPrice(3);
        product.setStock(205);
        product.setSupplier(supplier);
        product.setProductCategory(productCategory);
        product.setVendingPrice(5);
        productDAO.createProduct(product);
        Assert.assertNotNull(product);
    }

    @Test
    public void readProduct(){
        Product prod = productDAO.readProduct(1L);
        Long actual = prod.getId();
        Long expected = 1L;
        System.out.println(prod.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateProduct(){
        Supplier supplier = new Supplier();
        supplier.setName("five continents");
        supplier.setContactNo("0477998822");
        supplier.setCity("Iasi");
        supplierDAO.createSupplier(supplier);

        Product prod = productDAO.readProduct(1L);
        System.out.println("Update:" + prod);
        prod.setName("lapte");
        prod.setSupplierPrice(3);
        prod.setStock(205);
        prod.setSupplier(supplier);
        productDAO.createProduct(prod);
        System.out.println(prod);
    }

    @Test
    public void deleteEmployee() {
        Product prod = productDAO.deleteProduct(1L);
        Assert.assertNotNull(prod);

    }



}
