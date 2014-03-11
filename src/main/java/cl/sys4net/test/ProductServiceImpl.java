package cl.sys4net.test;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cl.sys4net.test.api.ProductService;
import cl.sys4net.test.dto.Greeter;

@Service
public class ProductServiceImpl implements ProductService {

    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductServiceImpl.class.getName());

    @Inject
    private Greeter greeter;

    @PostConstruct
    protected void init() {
        if (greeter == null) {
            throw new IllegalStateException("The Greeter hasn't been provided.");
        }
    }

    @Override
    public String create(String name) {
        String msg = greeter.createGreeting(name);

        LOGGER.info(msg);

        return msg;
    }

}
