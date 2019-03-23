package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductDAO;
import ro.sda.hypermarket.core.entity.Product;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public void createProduct(Product product) {
        productDAO.createProduct(product);
    }

    @Override
    public Product readProduct(Long productId) {
        return productDAO.readProduct(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public Product deleteProduct(Long productId) {
        return productDAO.deleteProduct(productId);
    }
}
