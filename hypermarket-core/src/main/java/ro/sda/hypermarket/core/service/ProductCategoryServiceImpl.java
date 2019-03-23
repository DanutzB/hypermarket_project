package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductCategoryDAO;
import ro.sda.hypermarket.core.entity.ProductCategory;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Override
    public void createProductCategory(ProductCategory productCategory) {
        productCategoryDAO.createProductCategory(productCategory);
    }

    @Override
    public ProductCategory readProductCategory(Long productCategoryId) {
        return productCategoryDAO.readProductCategory(productCategoryId);
    }

    @Override
    public void updateProductCategory(ProductCategory productCategory) {
        productCategoryDAO.updateProductCategory(productCategory);
    }

    @Override
    public ProductCategory deleteProductCategory(Long productCategoryId) {
        return productCategoryDAO.deleteProductCategory(productCategoryId);
    }
}
