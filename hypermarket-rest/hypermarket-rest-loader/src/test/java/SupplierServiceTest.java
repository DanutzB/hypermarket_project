import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDAO;
import ro.sda.hypermarket.core.entity.Supplier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SupplierServiceTest {

    @Autowired
    private SupplierDAO supplierDAO;

    @Test
    public void testCreate() {
        Supplier supplier = new Supplier();
        supplier.setName("George");
        supplier.setContactNo("0751733488");
        supplier.setCity("Iasi");
        supplierDAO.createSupplier(supplier);
        Assert.assertNotNull(supplier);
    }

    @Test
    public void testRead() {
        Supplier sup = supplierDAO.readSupplier(1L);
        Long actual = sup.getId();
        Long expected = 1L;
        System.out.println(sup.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdate() {
        Supplier sup = supplierDAO.readSupplier(2L);
        System.out.println("Update " + sup + " to:");
        sup.setName("Ionut");
        sup.setContactNo("0766666666");
        sup.setCity("Oradea");
        supplierDAO.updateSupplier(sup);
        Supplier expected = supplierDAO.readSupplier(2L);
        Supplier actual = sup;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {

    }


}
