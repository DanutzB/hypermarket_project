import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDAO;
import ro.sda.hypermarket.core.entity.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ClientServiceTest {

    @Autowired
    private ClientDAO clientDAO;

    @Test
    public void testCreate(){
        Client client = new Client();
        client.setName("Vasile");
        clientDAO.createClient(client);
        Assert.assertNotNull(client);
    }

    @Test
    public void testRead(){
        Client cli = clientDAO.readClient(1L);
        Long actual = cli.getId();
        Long expected = 1L;
        System.out.println(cli.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdate(){
        Client cli = clientDAO.readClient(2L);
        System.out.println("Update " + cli + " to:");
        cli.setName("Ionut");
        clientDAO.updateClient(cli);
        Client expected = clientDAO.readClient(2L);
        Client actual = cli;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete(){
        //todo delete
    }

}
