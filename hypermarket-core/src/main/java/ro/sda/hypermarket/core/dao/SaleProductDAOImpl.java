package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.SaleProduct;

@Repository
@Transactional
public class SaleProductDAOImpl implements SaleProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createSaleProduct(SaleProduct saleProduct) {
        sessionFactory.getCurrentSession().save(saleProduct);
    }

    @Override
    public SaleProduct readSaleProduct(Long saleProductId) {
        SaleProduct saleProduct = (SaleProduct) sessionFactory.getCurrentSession().get(SaleProduct.class, saleProductId);
        return saleProduct;
    }

    @Override
    public SaleProduct updateSaleProduct(SaleProduct saleProduct) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        SaleProduct saleProduct1 = readSaleProduct(saleProduct.getId());
        sessionFactory.getCurrentSession().merge(saleProduct1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return saleProduct1;
    }

    @Override
    public void deleteSaleProduct(SaleProduct saleProduct) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        SaleProduct found = (SaleProduct) sessionFactory.getCurrentSession().get(SaleProduct.class, saleProduct.getId());
        sessionFactory.getCurrentSession().delete(found);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
