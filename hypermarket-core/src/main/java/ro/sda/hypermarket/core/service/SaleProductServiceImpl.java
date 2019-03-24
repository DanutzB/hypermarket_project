package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SaleProductDAO;
import ro.sda.hypermarket.core.entity.SaleProduct;
import ro.sda.hypermarket.core.repository.SaleProductRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SaleProductServiceImpl implements SaleProductService {

    @Autowired
    private SaleProductDAO saleProductDAO;
    @Autowired
    private SaleProductRepository saleProductRepository;

    @Override
    public void createSaleProduct(SaleProduct saleProduct, boolean useHibernate) {
        if(useHibernate){
            saleProductDAO.createSaleProduct(saleProduct);
        }
            saleProductRepository.save(saleProduct);
    }

    @Override
    public SaleProduct readSaleProduct(Long saleProductId, boolean useHibernate) {
        if(useHibernate){
            return saleProductDAO.readSaleProduct(saleProductId);
        }
            return saleProductRepository.findById(saleProductId);
    }

    @Override
    public SaleProduct updateSaleProduct(SaleProduct saleProduct, boolean useHibernate) {
        if(useHibernate){
            return saleProductDAO.updateSaleProduct(saleProduct);
        }
            return saleProductRepository.save(saleProduct);
    }

    @Override
    public void deleteSaleProduct(SaleProduct saleProduct, boolean useHibernate) {
        if(useHibernate){
            saleProductDAO.deleteSaleProduct(saleProduct);
        }
            saleProductRepository.delete(saleProduct);
    }
}
