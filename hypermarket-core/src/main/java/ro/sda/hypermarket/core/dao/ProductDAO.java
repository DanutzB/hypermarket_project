package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Product;

public interface ProductDAO {
    void createProduct(Product product);

    Product readProduct(Long productId);

    void updateProduct(Product product);

    Product deleteProduct(Long productId);
}
