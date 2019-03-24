package ro.sda.hypermarket.core.repository;

import org.springframework.data.jpa.repository.Query;
import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierRepository extends EntityRepository<Supplier> {

    public Supplier findByName(String name);

//    pt query-uri mai complicate
//    @Query(value = "aici e query-ul meu HQL")
//    public List<Supplier> unNumeDeMetoda(String param1, int param2);
//
//    @Query(value = "aici e query-ul meu SQL", native = true)
//    public List<Supplier> unNumeDeMetoda(String param1, int param2);

}
