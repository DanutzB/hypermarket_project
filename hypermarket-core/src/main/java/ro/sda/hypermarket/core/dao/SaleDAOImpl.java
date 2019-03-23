package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Sale;

@Repository
@Transactional
public class SaleDAOImpl implements SaleDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void createSale(Sale sale) {
        sessionFactory.getCurrentSession().save(sale);
    }

    @Override
    public Sale readSale(Long saleId) {
        Sale sale = (Sale) sessionFactory.getCurrentSession().get(Sale.class, saleId);

        return sale;
    }

    @Override
    public Sale updateSale(Sale sale) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Sale sale1 = readSale(sale.getId());
        sessionFactory.getCurrentSession().merge(sale1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return sale1;

    }

    @Override
    public void deleteSale (Sale sale) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Sale found = (Sale) sessionFactory.getCurrentSession().get(Sale.class, sale.getId());
        sessionFactory.getCurrentSession().delete(found);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
