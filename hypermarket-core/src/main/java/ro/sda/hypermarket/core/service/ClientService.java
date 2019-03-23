package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Client;

public interface ClientService {

    void createClient(Client client);

    Client readClient(Long clientId);

    Client updateClient(Client client);

    void deleteClient(Client client);

}
