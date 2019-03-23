package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDAO;
import ro.sda.hypermarket.core.entity.Supplier;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDAO supplierDAO;
    
    @Override
    public void createSupplier(Supplier supplier) {
        supplierDAO.createSupplier(supplier);
    }

    @Override
    public Supplier readSupplier(Long supplierId) {
        return supplierDAO.readSupplier(supplierId);
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return supplierDAO.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(Supplier supplier) {
        supplierDAO.deleteSupplier(supplier);
    }
}
