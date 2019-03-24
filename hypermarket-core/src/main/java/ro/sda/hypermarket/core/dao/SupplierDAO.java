package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Supplier;

public interface SupplierDAO {

    Supplier createSupplier(Supplier supplier);

    Supplier readSupplier(Long supplierId);

    Supplier updateSupplier(Supplier supplier);

    void deleteSupplier(Supplier supplier);
}
