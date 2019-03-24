import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.service.SupplierService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SupplierServiceTest {

    @Autowired
    private SupplierService supplierService;

    @Test
    public void testCreate() {
        Supplier supplier = new Supplier();
        supplier.setName("George");
        supplier.setContactNo("0751733488");
        supplier.setCity("Iasi");
        supplierService.createSupplier(supplier);
        Assert.assertNotNull(supplier);
    }

    @Test
    public void testRead() {
        Supplier sup = supplierService.readSupplier(1L);
        Long actual = sup.getId();
        Long expected = 1L;
        System.out.println(sup.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdate() {
        Supplier sup = supplierService.readSupplier(2L);
        System.out.println("Update " + sup + " to:");
        sup.setName("Ionut");
        sup.setContactNo("0766666666");
        sup.setCity("Oradea");
        supplierService.updateSupplier(sup);
        Supplier expected = supplierService.readSupplier(2L);
        Supplier actual = sup;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {
        Supplier supplier = supplierService.readSupplier(1L);
        supplierService.deleteSupplier(supplier);
        Assert.assertNotNull(supplier);
    }


}
