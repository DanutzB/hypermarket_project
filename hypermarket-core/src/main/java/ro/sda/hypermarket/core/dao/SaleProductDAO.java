package ro.sda.hypermarket.core.dao;


import ro.sda.hypermarket.core.entity.SaleProduct;

public interface SaleProductDAO {
    void createSaleProduct (SaleProduct saleProduct);

    SaleProduct readSaleProduct(Long saleProductId);

    SaleProduct updateSaleProduct (SaleProduct saleProduct);

    void deleteSaleProduct(SaleProduct saleProduct);
}
