package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDAO;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.repository.SupplierRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(Supplier supplier, boolean useHibernate) {
        if(useHibernate) {
            return supplierDAO.createSupplier(supplier);
        }
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier readSupplier(Long supplierId, boolean useHibernate) {
        if(useHibernate){
        return supplierDAO.readSupplier(supplierId);
        }
        return supplierRepository.findById(supplierId);
    }

    @Override
    public Supplier updateSupplier(Supplier supplier, boolean useHibernate) {
        if(useHibernate){
            return supplierDAO.updateSupplier(supplier);
        }
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Supplier supplier, boolean useHibernate) {
        if(useHibernate){
            supplierDAO.deleteSupplier(supplier);
        }
        supplierRepository.delete(supplier);
    }
}
