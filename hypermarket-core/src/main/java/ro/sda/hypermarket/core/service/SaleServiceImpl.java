package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SaleDAO;
import ro.sda.hypermarket.core.entity.Sale;
import ro.sda.hypermarket.core.repository.SaleRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDAO saleDAO;
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void createSale(Sale sale, boolean useHibernate) {
        if(useHibernate){
            saleDAO.createSale(sale);
        }
            saleRepository.save(sale);
    }

    @Override
    public Sale readSale(Long saleId, boolean useHibernate) {
        if(useHibernate){
            return saleDAO.readSale(saleId);
        }
            return saleRepository.findById(saleId);
    }

    @Override
    public Sale updateSale(Sale sale, boolean useHibernate) {
        if(useHibernate){
            return saleDAO.updateSale(sale);
        }
            return saleRepository.save(sale);
    }

    @Override
    public void deleteSale(Sale sale, boolean useHibernate) {
        if(useHibernate){
            saleDAO.deleteSale(sale);
        }
            saleRepository.delete(sale);
    }
}
