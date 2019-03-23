package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Product;

public interface ProductService {
    void createProduct(Product product);

    Product readProduct(Long productId);

    void updateProduct(Product product);

    Product deleteProduct(Long productId);
}
