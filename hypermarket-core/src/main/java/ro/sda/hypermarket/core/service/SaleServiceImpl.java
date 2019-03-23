package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SaleDAO;
import ro.sda.hypermarket.core.entity.Sale;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDAO saleDAO;

    @Override
    public void createSale(Sale sale) {
        saleDAO.createSale(sale);
    }

    @Override
    public Sale readSale(Long saleId) {
        return saleDAO.readSale(saleId);
    }

    @Override
    public Sale updateSale(Sale sale) {
        return saleDAO.updateSale(sale);
    }

    @Override
    public void deleteSale(Sale sale) {
        saleDAO.deleteSale(sale);
    }
}
