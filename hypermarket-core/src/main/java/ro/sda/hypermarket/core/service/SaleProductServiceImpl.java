package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SaleProductDAO;
import ro.sda.hypermarket.core.entity.SaleProduct;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SaleProductServiceImpl implements SaleProductService {

    @Autowired
    private SaleProductDAO saleProductDAO;

    @Override
    public void createSaleProduct(SaleProduct saleProduct) {
        saleProductDAO.createSaleProduct(saleProduct);
    }

    @Override
    public SaleProduct readSaleProduct(Long saleProductId) {
        return saleProductDAO.readSaleProduct(saleProductId);
    }

    @Override
    public SaleProduct updateSaleProduct(SaleProduct saleProduct) {
        return saleProductDAO.updateSaleProduct(saleProduct);
    }

    @Override
    public void deleteSaleProduct(SaleProduct saleProduct) {
        saleProductDAO.deleteSaleProduct(saleProduct);
    }
}
