import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientService;
import ro.sda.hypermarket.core.entity.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    public void testCreate(){
        Client client = new Client();
        client.setName("Vasile");
        clientService.createClient(client);
        Assert.assertNotNull(client);
    }

    @Test
    public void testRead(){

        Client cli = clientService.readClient(1L);
        Long actual = cli.getId();
        Long expected = 1L;
        System.out.println(cli.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdate(){
        Client cli = clientService.readClient(2L);
        System.out.println("Update " + cli + " to:");
        cli.setName("Ionut");
        clientService.updateClient(cli);
        Client expected = clientService.readClient(2L);
        Client actual = cli;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete(){
        Client client = clientService.readClient(1L);
        clientService.deleteClient(client);
        Assert.assertNotNull(client);
    }

}
