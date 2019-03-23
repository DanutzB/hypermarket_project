package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.ProductCategory;

public interface ProductCategoryService {
    void createProductCategory(ProductCategory productCategory);

    ProductCategory readProductCategory(Long productCategoryId);

    void updateProductCategory(ProductCategory productCategory);

    ProductCategory deleteProductCategory(Long productCategoryId);
}
