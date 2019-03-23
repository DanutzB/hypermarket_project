package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Client;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientService clientDAO;


    @Override
    public void createClient(Client client) {
        clientDAO.createClient(client);
    }

    @Override
    public Client readClient(Long clientId) {
        return clientDAO.readClient(clientId);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDAO.updateClient(client);

    }

    @Override
    public void deleteClient(Client client) {
        clientDAO.deleteClient(client);
    }
}
