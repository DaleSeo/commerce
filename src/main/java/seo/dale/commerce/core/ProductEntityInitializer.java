package seo.dale.commerce.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.member.MemberService;
import seo.dale.commerce.product.Product;
import seo.dale.commerce.product.ProductService;

import javax.annotation.PostConstruct;

@Component
@Profile("!production")
public class ProductEntityInitializer {

    @Autowired
    private ProductService service;

    @PostConstruct
    public void initializer() {
        service.create(newProduct(1L, "Apple", "Red apple", 1000.1F, 100));
        service.create(newProduct(2L, "Banana", "Yellow banana", 2000.0F, 1000));
        service.create(newProduct(3L, "Mellon", "Green mellon", 500.0F, 500));
    }

    private Product newProduct(Long id, String name, String description, Float price, Integer stock) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        return product;
    }

}
