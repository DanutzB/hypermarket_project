import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.service.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    @Rollback(false)
    public void testCreate(){
        Client client = new Client();
        client.setName("Constantin");
        clientService.createClient(client, false);
        Assert.assertNotNull(client);
    }

    @Test
    @Rollback(false)
    public void testRead(){

        Client cli = clientService.readClient(1L, false);
        Long actual = cli.getId();
        Long expected = 1L;
        System.out.println(cli.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate(){
        Client cli = clientService.readClient(2L, false);
        System.out.println("Update " + cli + " to:");
        cli.setName("Ionut");
        clientService.updateClient(cli, false);
        Client expected = clientService.readClient(2L, false);
        Client actual = cli;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testDelete(){
        Client client = clientService.readClient(1L, false);
        clientService.deleteClient(client, false);
        Assert.assertNotNull(client);
    }

}
