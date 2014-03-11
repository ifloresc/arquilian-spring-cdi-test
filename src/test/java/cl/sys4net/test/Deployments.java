package cl.sys4net.test;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import cl.sys4net.test.api.ProductService;
import cl.sys4net.test.dto.Greeter;
import cl.sys4net.test.dto.PhraseBuilder;

public final class Deployments {

    public static JavaArchive createDeployment() {

        return ShrinkWrap
                .create(JavaArchive.class, "spring-test.jar")
                .addClasses(ProductService.class, ProductServiceImpl.class,
                        Greeter.class, PhraseBuilder.class)
                .addAsResource("applicationContext.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
