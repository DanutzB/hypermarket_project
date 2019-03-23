import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.*;
import ro.sda.hypermarket.core.entity.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SaleProductServiceTest {

    @Autowired
    private SaleProductDAO saleProductDAO;

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Autowired
    private ProductDAO productDAO;

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

        SaleProduct saleProduct = new SaleProduct();
        saleProduct.setQuantity(334455L);
        saleProduct.setProduct(product);
        saleProductDAO.createSaleProduct(saleProduct);
    }

    @Test
    public void testRead(){
        SaleProduct saleProduct = saleProductDAO.readSaleProduct(1L);
        Long actual = saleProduct.getId();
        Long expected = 1L;
        System.out.println(saleProduct.toString());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testUpdate(){

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

        SaleProduct saleProduct = saleProductDAO.readSaleProduct(1L);
        System.out.println("Update " + saleProduct + " to:");
        saleProduct.setProduct(product);
        saleProduct.setQuantity(12L);
        saleProduct.setProductId(product.getId());

        saleProductDAO.updateSaleProduct(saleProduct);
        SaleProduct expected = saleProductDAO.readSaleProduct(1L);
        SaleProduct actual = saleProduct;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete(){
        SaleProduct saleProduct = saleProductDAO.readSaleProduct(1L);
        saleProductDAO.deleteSaleProduct(saleProduct);
        Assert.assertNotNull(saleProduct);
    }
}
