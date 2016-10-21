package seo.dale.commerce.order;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.commerce.TestUtils;
import seo.dale.commerce.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	private Member member;

	@Before
	public void setUp() {
		member = TestUtils.persistTestMember(entityManager);
	}

	@Test
	public void testSave() {
		Order order = new Order();
		order.setMember(member);
		order.setTotal(35000);
		repository.save(order);

		entityManager.clear(); // Clear persistence context so entity manager queries again.

		Order saved = entityManager.find(Order.class, order.getId());

		assertThat(saved.getId()).isEqualTo(order.getId());
		assertThat(saved.getTotal()).isEqualTo(order.getTotal());

		Member savedMember = entityManager.find(Member.class, member.getId());
		assertThat(savedMember.getOrders().size()).isEqualTo(1);
		assertThat(savedMember.getOrders().contains(saved)).isTrue();
	}

	@Test
	public void testFindOne() {
		Order order = new Order();
		order.setMember(member);
		order.setTotal(35000);
		entityManager.persist(order);

		Order found = repository.findOne(order.getId());
		assertThat(EqualsBuilder.reflectionEquals(found, order)).isTrue();
	}


}