package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductCategoryDAO;
import ro.sda.hypermarket.core.entity.ProductCategory;
import ro.sda.hypermarket.core.repository.ProductCategoryRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDAO productCategoryDAO;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public void createProductCategory(ProductCategory productCategory, boolean useHibernate) {
        if (useHibernate) {
            productCategoryDAO.createProductCategory(productCategory);
        }
        productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory readProductCategory(Long productCategoryId, boolean useHibernate) {
        if (useHibernate) {
            return productCategoryDAO.readProductCategory(productCategoryId);
        }
        return productCategoryRepository.findById(productCategoryId);
    }

    @Override
    public void updateProductCategory(ProductCategory productCategory, boolean useHibernate) {
        if (useHibernate) {
            productCategoryDAO.updateProductCategory(productCategory);
        }
        productCategoryRepository.save(productCategory);
    }

    @Override
    public void deleteProductCategory(Long productCategoryId, boolean useHibernate) {
        if (useHibernate) {
            productCategoryDAO.deleteProductCategory(productCategoryId);
        }
        productCategoryRepository.delete(productCategoryId);

    }

}
