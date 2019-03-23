package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Client;

public interface ClientDAO {

    void createClient(Client client);

    Client readClient(Long clientId);

    Client updateClient(Client client);

    void deleteClient(Client client);
}