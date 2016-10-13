package seo.dale.commerce.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.commerce.core.ModelFactory;

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
        Product saved = ModelFactory.newProduct("Apple", "Red apple", 1000.1F, 100);
        // When
        service.create(saved);
        // Then
        Product found = repository.findOne(saved.getId());
        assertThat(found.getName()).isEqualTo("Apple");
        assertThat(found.getDescription()).isEqualTo("Red apple");
        assertThat(found.getPrice()).isEqualTo(1000.1F);
        assertThat(found.getStock()).isEqualTo(100);
    }

}