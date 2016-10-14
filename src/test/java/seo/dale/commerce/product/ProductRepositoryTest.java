package seo.dale.commerce.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.commerce.core.ModelFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository repository;

    @Test
    public void testSave() {
        Product saved = repository.save(ModelFactory.newProduct("Apple", "Red apple", 1000.1F, 100));
        Product found = entityManager.find(Product.class, 1L);

        assertThat(found).isSameAs(saved);
        assertThat(found.getName()).isEqualTo("Apple");
        assertThat(found.getDescription()).isEqualTo("Red apple");
        assertThat(found.getPrice()).isEqualTo(1000.1F);
        assertThat(found.getStock()).isEqualTo(100);
    }

    @Test
    public void testFindOne() {
        Product saved = entityManager.persist(ModelFactory.newProduct("Apple", "Red apple", 1000.1F, 100));
        Product found = repository.findOne(1L);

        assertThat(found).isSameAs(saved);
        assertThat(found.getName()).isEqualTo("Apple");
        assertThat(found.getDescription()).isEqualTo("Red apple");
        assertThat(found.getPrice()).isEqualTo(1000.1F);
        assertThat(found.getStock()).isEqualTo(100);
    }

    @Test
    public void testFindAll() {
        Product saved1 = entityManager.persist(ModelFactory.newProduct("Apple", "Red apple", 1000.1F, 100));
        Product saved2 = entityManager.persist(ModelFactory.newProduct("Banana", "Yellow banana", 2000.0F, 1000));
        Product saved3 = entityManager.persist(ModelFactory.newProduct("Mellon", "Green mellon", 500.0F, 500));
        List<Product> list = repository.findAll();

        assertThat(list).hasSize(3).contains(saved1).contains(saved2).contains(saved3);
    }

    @Test
    public void testDelete() {
        entityManager.persist(ModelFactory.newProduct("Apple", "Red apple", 1000.1F, 100));
        repository.delete(1L);
        Product found = entityManager.find(Product.class, 1L);

        assertThat(found).isNull();
    }

}