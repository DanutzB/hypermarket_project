package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Sale;

public interface SaleDAO {

    void createSale (Sale sale);

    Sale readSale(Long saleId);

    Sale updateSale (Sale sale);

    void deleteSale(Sale sale);
}
