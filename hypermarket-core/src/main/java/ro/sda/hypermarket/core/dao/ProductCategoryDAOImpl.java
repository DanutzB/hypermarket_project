package ro.sda.hypermarket.core.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.ProductCategory;

@Repository
@Transactional
public class ProductCategoryDAOImpl implements ProductCategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createProductCategory(ProductCategory productCategory) {
        sessionFactory.getCurrentSession().save(productCategory);
    }
    @Override
    public ProductCategory readProductCategory(Long productCategoryId) {
        ProductCategory productCategory = (ProductCategory) sessionFactory.getCurrentSession().get(ProductCategory.class, productCategoryId);
        return productCategory;
    }

    @Override
    public void updateProductCategory(ProductCategory productCategory) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            ProductCategory prodCatToBeUpdated = (ProductCategory) session.get(ProductCategory.class, productCategory.getId());
            prodCatToBeUpdated.setName(productCategory.getName());
            prodCatToBeUpdated.setManager(productCategory.getManager());
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null)tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public ProductCategory deleteProductCategory(Long id) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        ProductCategory found = (ProductCategory) sessionFactory.getCurrentSession().get(ProductCategory.class, id);
        sessionFactory.getCurrentSession().delete(found);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return found;
    }


}
