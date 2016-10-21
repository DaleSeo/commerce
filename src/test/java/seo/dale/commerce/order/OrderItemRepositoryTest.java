package seo.dale.commerce.order;

import org.junit.After;
import org.junit.Before;
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

	private Order order;
	private Product[] products;

	@Before
	public void setUp() {
		order = TestUtils.persistTestOrder(entityManager);
		products = new Product[]{
				TestUtils.persistTestProduct(entityManager),
				TestUtils.persistTestProduct(entityManager, 1)
		};
	}

	@Test
	public void testSave() {
		OrderItem orderItem0 = new OrderItem();
		orderItem0.setOrder(order);
		orderItem0.setProduct(products[0]);
		orderItem0.setQuantity(2);
		orderItem0.setPrice(orderItem0.getQuantity() * products[0].getPrice());

		repository.save(orderItem0);

		OrderItem orderItem1 = new OrderItem();
		orderItem1.setOrder(order);
		orderItem1.setProduct(products[1]);
		orderItem1.setQuantity(3);
		orderItem1.setPrice(orderItem0.getQuantity() * products[1].getPrice());

		repository.save(orderItem1);

		entityManager.clear();

		OrderItem foundOrderItem0 = entityManager.find(OrderItem.class, orderItem0.getId());
		assertThat(foundOrderItem0.getId()).isEqualTo(orderItem0.getId());
		assertThat(foundOrderItem0.getQuantity()).isEqualTo(orderItem0.getQuantity());
		assertThat(foundOrderItem0.getPrice()).isEqualTo(orderItem0.getPrice());
		assertThat(foundOrderItem0.getOrder().getId()).isEqualTo(order.getId());
		assertThat(foundOrderItem0.getProduct().getId()).isEqualTo(products[0].getId());

		OrderItem foundOrderItem1 = entityManager.find(OrderItem.class, orderItem1.getId());
		assertThat(foundOrderItem1.getId()).isEqualTo(orderItem1.getId());
		assertThat(foundOrderItem1.getQuantity()).isEqualTo(orderItem1.getQuantity());
		assertThat(foundOrderItem1.getPrice()).isEqualTo(orderItem1.getPrice());
		assertThat(foundOrderItem1.getOrder().getId()).isEqualTo(order.getId());
		assertThat(foundOrderItem1.getProduct().getId()).isEqualTo(products[1].getId());

		entityManager.clear();

		// OneToMany Test
		Order foundOrder = entityManager.find(Order.class, order.getId());
		assertThat(foundOrder.getOrderItems().size() == 2);
	}

	@Test
	public void testFind() {
		OrderItem orderItem0 = new OrderItem();
		orderItem0.setOrder(order);
		orderItem0.setProduct(products[0]);
		orderItem0.setQuantity(2);
		orderItem0.setPrice(orderItem0.getQuantity() * products[0].getPrice());

		entityManager.persist(orderItem0);

		OrderItem orderItem1 = new OrderItem();
		orderItem1.setOrder(order);
		orderItem1.setProduct(products[1]);
		orderItem1.setQuantity(3);
		orderItem1.setPrice(orderItem0.getQuantity() * products[1].getPrice());

		entityManager.persist(orderItem1);

		entityManager.clear();

		OrderItem foundOrderItem0 = repository.findOne(orderItem0.getId());
		assertThat(foundOrderItem0.getId()).isEqualTo(orderItem0.getId());
		assertThat(foundOrderItem0.getQuantity()).isEqualTo(orderItem0.getQuantity());
		assertThat(foundOrderItem0.getPrice()).isEqualTo(orderItem0.getPrice());
		assertThat(foundOrderItem0.getOrder().getId()).isEqualTo(order.getId());
		assertThat(foundOrderItem0.getProduct().getId()).isEqualTo(products[0].getId());

		OrderItem foundOrderItem1 = repository.findOne(orderItem1.getId());
		assertThat(foundOrderItem1.getId()).isEqualTo(orderItem1.getId());
		assertThat(foundOrderItem1.getQuantity()).isEqualTo(orderItem1.getQuantity());
		assertThat(foundOrderItem1.getPrice()).isEqualTo(orderItem1.getPrice());
		assertThat(foundOrderItem1.getOrder().getId()).isEqualTo(order.getId());
		assertThat(foundOrderItem1.getProduct().getId()).isEqualTo(products[1].getId());
	}

	@After
	public void tearDown() {
		entityManager.clear();
	}
}