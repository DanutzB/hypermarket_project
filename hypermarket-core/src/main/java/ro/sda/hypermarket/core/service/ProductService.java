package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Product;

public interface ProductService {
    void createProduct(Product product, boolean useHibernate);

    Product readProduct(Long productId, boolean useHibernate);

    void updateProduct(Product product, boolean useHibernate);

    Product deleteProduct(Long productId, boolean useHibernate);
}
