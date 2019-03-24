package ro.sda.hypermarket.core.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository <T extends BaseEntity> extends JpaRepository<T, Long> {
//    serch record by id
//            @param id the id of the requested record
//            @return the record with the specified id

    public T findById(long id);

}
