package seo.dale.commerce.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import seo.dale.commerce.product.ProductService;

import javax.annotation.PostConstruct;

@Component
@Profile("!production")
public class ProductEntityInitializer {

    @Autowired
    private ProductService service;

    @PostConstruct
    public void initializer() {
        service.create(ModelFactory.newProduct("Apple", "Red apple", 1000.1, 100));
        service.create(ModelFactory.newProduct("Banana", "Yellow banana", 2000.0, 1000));
        service.create(ModelFactory.newProduct("Mellon", "Green mellon", 500.0, 500));
    }

}
