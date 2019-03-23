package ro.sda.hypermarket.core.dao;
import ro.sda.hypermarket.core.entity.ProductCategory;

public interface ProductCategoryDAO {

    void createProductCategory(ProductCategory productCategory);

    ProductCategory readProductCategory(Long productCategoryId);

    void updateProductCategory(ProductCategory productCategory);

    ProductCategory deleteProductCategory(Long productCategoryId);
}
