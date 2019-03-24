package ro.sda.hypermarket.core.repository;

import org.springframework.data.jpa.repository.Query;
import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.Client;

import java.util.List;
public interface ClientRepository extends EntityRepository<Client> {

    public Client findByName(String name);


}
