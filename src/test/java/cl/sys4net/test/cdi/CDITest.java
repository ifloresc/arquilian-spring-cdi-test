package cl.sys4net.test.cdi;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import cl.sys4net.test.Deployments;
import cl.sys4net.test.dto.Greeter;

/**
 * Test con CDI
 */
@RunWith(Arquillian.class)
public class CDITest {

    @Deployment
    public static JavaArchive createTestArchive() {
        return Deployments.createDeployment();

    }

    @Inject
    Greeter greeter;

    @Test
    public void create() {
        assertEquals("Hello, Earthling!", greeter.createGreeting("Earthling"));

        greeter.greet(System.out, "Earthling");
    }

}
