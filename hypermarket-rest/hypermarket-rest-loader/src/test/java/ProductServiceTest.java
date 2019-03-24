import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.dao.ProductCategoryDAO;
import ro.sda.hypermarket.core.dao.ProductDAO;
import ro.sda.hypermarket.core.dao.SupplierDAO;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.ProductCategory;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.service.EmployeeService;
import ro.sda.hypermarket.core.service.ProductCategoryService;
import ro.sda.hypermarket.core.service.ProductService;
import ro.sda.hypermarket.core.service.SupplierService;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private EmployeeService employeeService;

    @Test
    @Rollback(false)
    public void testCreate(){
        Supplier supplier = new Supplier();
        supplier.setName("George");
        supplier.setContactNo("0751733488");
        supplier.setCity("Iasi");
        supplierService.createSupplier(supplier, false);

        Employee employee = new Employee();
        employee.setFirstName("Vasile");
        employee.setLastName("Ionescu");
        employee.setCity("Iasi");
        employee.setJobTitle("manager");
        employee.setSalary(45000);
        employeeService.createEmployee(employee, false);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("dairy");
        productCategory.setManager(employee);
        productCategoryService.createProductCategory(productCategory, false);

        Product product = new Product();
        product.setName("lapte");
        product.setSupplierPrice(3);
        product.setStock(205);
        product.setSupplier(supplier);
        product.setProductCategory(productCategory);
        product.setVendingPrice(5);
        productService.createProduct(product, false);
        Assert.assertNotNull(product);
    }

    @Test
    @Rollback(false)
    public void readProduct(){
        Product prod = productService.readProduct(1L, false);
        Long actual = prod.getId();
        Long expected = 1L;
        System.out.println(prod.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void updateProduct(){
        Supplier supplier = new Supplier();
        supplier.setName("five continents");
        supplier.setContactNo("0477998822");
        supplier.setCity("Iasi");
        supplierService.createSupplier(supplier, false);

        Product prod = productService.readProduct(1L,false);
        System.out.println("Update:" + prod);
        prod.setName("lapte");
        prod.setSupplierPrice(3);
        prod.setStock(205);
        prod.setSupplier(supplier);
        productService.createProduct(prod, false);
        System.out.println(prod);
    }

    @Test
    @Rollback(false)
    public void deleteEmployee() {
        Product prod = productService.deleteProduct(1L, false);
        Assert.assertNotNull(prod);

    }



}
