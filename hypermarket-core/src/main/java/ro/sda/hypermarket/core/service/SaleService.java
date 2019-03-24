package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Sale;

public interface SaleService {
    void createSale (Sale sale, boolean useHibernate);

    Sale readSale(Long saleId, boolean useHibernate);

    Sale updateSale (Sale sale, boolean useHibernate);

    void deleteSale(Sale sale, boolean useHibernate);
}
