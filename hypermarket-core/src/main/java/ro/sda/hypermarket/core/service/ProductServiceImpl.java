package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductDAO;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.repository.ProductRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product, boolean useHibernate) {
        if(useHibernate){
            productDAO.createProduct(product);
        }
            productRepository.save(product);
    }

    @Override
    public Product readProduct(Long productId, boolean useHibernate) {
        if(useHibernate){
            return productDAO.readProduct(productId);
        }
            return productRepository.findById(productId);
    }

    @Override
    public void updateProduct(Product product, boolean useHibernate) {
        if(useHibernate){
            productDAO.updateProduct(product);
        }
            productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Long productId, boolean useHibernate) {
        if(useHibernate){
            productDAO.deleteProduct(productId);
        }
            productRepository.delete(productId);
        return null;
    }
}
