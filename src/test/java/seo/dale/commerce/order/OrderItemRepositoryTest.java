package seo.dale.commerce.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.commerce.TestUtils;
import seo.dale.commerce.product.Product;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderItemRepositoryTest {

	@Autowired
	private OrderItemRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testSave() {
		Order order = TestUtils.persistTestOrder(entityManager);
		Product product = TestUtils.persistTestProduct(entityManager);

		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(order);
		orderItem.setProduct(product);
		orderItem.setQuantity(2);
		orderItem.setPrice(orderItem.getQuantity() * product.getPrice());

		repository.save(orderItem);

		entityManager.clear();

		OrderItem foundOrderItem = entityManager.find(OrderItem.class, orderItem.getId());
		assertThat(foundOrderItem.getId()).isEqualTo(orderItem.getId());
		assertThat(foundOrderItem.getQuantity()).isEqualTo(orderItem.getQuantity());
		assertThat(foundOrderItem.getPrice()).isEqualTo(orderItem.getPrice());

		Order foundOrder = entityManager.find(Order.class, order.getId());
		assertThat(foundOrder.getId()).isEqualTo(order.getId());
		assertThat(foundOrder.getTotal()).isEqualTo(order.getTotal());

		Product foundProduct = entityManager.find(Product.class, product.getId());
		assertThat(foundProduct.getId()).isEqualTo(product.getId());
		assertThat(foundProduct.getName()).isEqualTo(product.getName());
	}

}