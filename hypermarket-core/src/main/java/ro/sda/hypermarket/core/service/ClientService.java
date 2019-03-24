package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Client;

public interface ClientService {

    Client createClient(Client client, boolean useHibernate);

    Client readClient(Long clientId, boolean useHibernate);

    Client updateClient(Client client, boolean useHibernate);

    void deleteClient(Client client, boolean useHibernate);

}
