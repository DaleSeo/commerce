package seo.dale.commerce.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.commerce.core.EntityFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testSave() {
        Product saved = repository.save(EntityFactory.newProduct("Apple", "Red apple", 1000.1, 100));
        Product found = entityManager.find(Product.class, saved.getId());

        assertThat(found).isSameAs(saved);
        assertThat(found.getName()).isEqualTo("Apple");
        assertThat(found.getDescription()).isEqualTo("Red apple");
        assertThat(found.getPrice()).isEqualTo(1000.1);
        assertThat(found.getStock()).isEqualTo(100);
    }

    @Test
    public void testFindOne() {
        Product saved = entityManager.persist(EntityFactory.newProduct("Apple", "Red apple", 1000.1, 100));
        Product found = repository.findOne(saved.getId());

        assertThat(found).isSameAs(saved);
        assertThat(found.getName()).isEqualTo("Apple");
        assertThat(found.getDescription()).isEqualTo("Red apple");
        assertThat(found.getPrice()).isEqualTo(1000.1);
        assertThat(found.getStock()).isEqualTo(100);
    }

    @Test
    public void testFindAll() {
        Product saved1 = entityManager.persist(EntityFactory.newProduct("Apple", "Red apple", 1000.1, 100));
        Product saved2 = entityManager.persist(EntityFactory.newProduct("Banana", "Yellow banana", 2000.0, 1000));
        Product saved3 = entityManager.persist(EntityFactory.newProduct("Mellon", "Green mellon", 500.0, 500));
        List<Product> list = repository.findAll();

        assertThat(list).hasSize(3).contains(saved1).contains(saved2).contains(saved3);
    }

    @Test
    public void testDelete() {
        Product saved = entityManager.persist(EntityFactory.newProduct("Apple", "Red apple", 1000.1, 100));
        repository.delete(saved.getId());
        Product found = entityManager.find(Product.class, 1L);

        assertThat(found).isNull();
    }

}