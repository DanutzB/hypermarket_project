package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Client;

@Repository
@Transactional
public class ClientDAOImpl implements ClientDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createClient(Client client) {
    sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public Client readClient(Long clientId) {
        Client client = (Client) sessionFactory.getCurrentSession().get(Client.class, clientId);
        return client;
    }

    @Override
    public Client updateClient(Client client) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Client client1 = readClient(client.getId());
        sessionFactory.getCurrentSession().merge(client1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return client;
    }

    @Override
    public void deleteClient(Client client) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Client found = (Client) sessionFactory.getCurrentSession().get(Client.class, client.getId());
        sessionFactory.getCurrentSession().delete(found);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
