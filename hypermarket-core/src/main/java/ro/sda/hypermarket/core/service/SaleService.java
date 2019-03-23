package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Sale;

public interface SaleService {
    void createSale (Sale sale);

    Sale readSale(Long saleId);

    Sale updateSale (Sale sale);

    void deleteSale(Sale sale);
}
