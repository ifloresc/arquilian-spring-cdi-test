package cl.sys4net.test.spring;

import static org.junit.Assert.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringConfiguration;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import cl.sys4net.test.ProductServiceImpl;
import cl.sys4net.test.api.ProductService;
import cl.sys4net.test.dto.Greeter;
import cl.sys4net.test.dto.PhraseBuilder;

/**
 * Test Para contexto Spring
 */
@RunWith(Arquillian.class)
@SpringConfiguration("applicationContext.xml")
public class ProductServiceTest  {

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap
                .create(JavaArchive.class, "spring-test.jar")
                .addClasses(ProductService.class, ProductServiceImpl.class,
                        Greeter.class, PhraseBuilder.class)
                .addAsResource("applicationContext.xml");

    }

    @Autowired
    private ProductService productService;

    @Test
    public void create() {
        String name = "Test";
        
        String msg = productService.create(name);

        assertEquals("Hello, Test!", msg);
    }

}
