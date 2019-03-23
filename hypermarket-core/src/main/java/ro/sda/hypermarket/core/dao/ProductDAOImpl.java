package ro.sda.hypermarket.core.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createProduct(Product product){
        sessionFactory.getCurrentSession().save(product);
    }
    @Override
    public Product readProduct(Long productId) {
        Product product = (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
        return product;
    }

    @Override
    public void updateProduct(Product product) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Product prodToBeUpdated = (Product) session.get(Product.class, product.getId());
            prodToBeUpdated.setId(product.getId());
            prodToBeUpdated.setName(product.getName());
            prodToBeUpdated.setSupplierPrice(product.getSupplierPrice());
            prodToBeUpdated.setStock(product.getStock());
            prodToBeUpdated.setSupplier(product.getSupplier());
            prodToBeUpdated.setProductCategory(product.getProductCategory());
            prodToBeUpdated.setVendingPrice(product.getVendingPrice());
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null)tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public Product deleteProduct(Long id) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Product found = (Product) sessionFactory.getCurrentSession().get(Product.class, id);
        sessionFactory.getCurrentSession().delete(found);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return found;
    }



}
