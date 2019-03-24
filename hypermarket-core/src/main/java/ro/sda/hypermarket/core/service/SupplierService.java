package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Supplier;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier, boolean useHibernate);

    Supplier readSupplier(Long supplierId, boolean useHibernate);

    Supplier updateSupplier(Supplier supplier, boolean useHibernate);

    void deleteSupplier(Supplier supplier, boolean useHibernate);
}
