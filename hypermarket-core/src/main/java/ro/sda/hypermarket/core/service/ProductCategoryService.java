package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.ProductCategory;

public interface ProductCategoryService {
    void createProductCategory(ProductCategory productCategory, boolean useHibernate);

    ProductCategory readProductCategory(Long productCategoryId, boolean useHibernate);

    void updateProductCategory(ProductCategory productCategory, boolean useHibernate);

    void deleteProductCategory(Long productCategoryId, boolean useHibernate);
}
