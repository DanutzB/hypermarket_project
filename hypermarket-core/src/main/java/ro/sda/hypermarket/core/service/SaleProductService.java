package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.SaleProduct;

public interface SaleProductService {

    void createSaleProduct(SaleProduct saleProduct);

    SaleProduct readSaleProduct(Long saleProductId);

    SaleProduct updateSaleProduct(SaleProduct saleProduct);

    void deleteSaleProduct(SaleProduct saleProduct);
}
