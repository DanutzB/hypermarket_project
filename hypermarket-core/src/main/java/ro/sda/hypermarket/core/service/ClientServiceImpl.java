package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.repository.ClientRepository;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientService clientDAO;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client, boolean useHibernate) {
        if(useHibernate){
            return clientDAO.createClient(client, false);
        }
        return clientRepository.save(client);
    }


    @Override
    public Client readClient(Long clientId, boolean useHibernate) {
        if(useHibernate){
            return clientDAO.readClient(clientId, false);
        }
        return clientRepository.findById(clientId);
    }

    @Override
    public Client updateClient(Client client, boolean useHibernate) {
        return clientDAO.updateClient(client, false);

    }

    @Override
    public void deleteClient(Client client, boolean useHibernate) {
        if(useHibernate){
            clientDAO.deleteClient(client, false);
        }
            clientRepository.delete(client);
    }
}
