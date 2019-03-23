package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Supplier;

public interface SupplierService {

    void createSupplier(Supplier supplier);

    Supplier readSupplier(Long supplierId);

    Supplier updateSupplier(Supplier supplier);

    void deleteSupplier(Supplier supplier);
}
