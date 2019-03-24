package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.SaleProduct;

public interface SaleProductService {

    void createSaleProduct(SaleProduct saleProduct, boolean useHibernate);

    SaleProduct readSaleProduct(Long saleProductId, boolean useHibernate);

    SaleProduct updateSaleProduct(SaleProduct saleProduct, boolean useHibernate);

    void deleteSaleProduct(SaleProduct saleProduct, boolean useHibernate);
}
