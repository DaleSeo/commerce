package seo.dale.commerce.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.commerce.core.EntityFactory;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService service;

    @Test
    public void testCreate() {
        // Given
        Product toSave = EntityFactory.newProduct("Apple", "Red apple", 1000.1, 100);
        // When
        // toSave.setCreatedDate(new Date());
        service.create(toSave);
        System.out.println("#toSave: " + toSave);
        System.out.println("#toSave.getCreatedDate(): " + toSave.getCreatedDate());
        // Then
        Product found = repository.findOne(toSave.getId());
        assertThat(found.getName()).isEqualTo("Apple");
        assertThat(found.getDescription()).isEqualTo("Red apple");
        assertThat(found.getPrice()).isEqualTo(1000.1);
        assertThat(found.getStock()).isEqualTo(100);
        assertThat(found.getCreatedDate()).isBefore(new Date());
    }

}