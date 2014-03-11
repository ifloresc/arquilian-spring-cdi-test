package cl.sys4net.test;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import cl.sys4net.test.dto.Greeter;
import cl.sys4net.test.dto.PhraseBuilder;

/**
 * Test con CDI
 */
@RunWith(Arquillian.class)
public class CDITest {

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "cdi-test.jar")
                .addClasses(Greeter.class, PhraseBuilder.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

    }

    @Inject
    Greeter greeter;

    @Test
    public void create() {
        assertEquals("Hello, Earthling!", greeter.createGreeting("Earthling"));
        
        greeter.greet(System.out, "Earthling");
    }

}
