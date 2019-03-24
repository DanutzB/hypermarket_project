package ro.sda.hypermarket.core.dao;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Supplier;


@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Supplier createSupplier(Supplier supplier) {
        sessionFactory.getCurrentSession().save(supplier);
        return supplier;
    }

    @Override
    public Supplier readSupplier(Long supplierId) {
        Supplier supplier = (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supplierId);

        return supplier;
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Supplier supplier1 = readSupplier(supplier.getId());
        sessionFactory.getCurrentSession().merge(supplier1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return supplier;

    }

    @Override
    public void deleteSupplier (Supplier supplier) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Supplier found = (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supplier.getId());
        sessionFactory.getCurrentSession().delete(found);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
