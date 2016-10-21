package seo.dale.commerce.order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.commerce.core.EntityFactory;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.member.MemberRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderServiceTest {

	private OrderService service;

	@Autowired
	private OrderRepository repository;

	@Autowired
	private MemberRepository memberRepository;

	private Member member;

	@Before
	public void setUp() {
		service = new OrderService(repository);
		member = memberRepository.save(EntityFactory.newMember("user", "", ""));
	}

	@Test
	public void testCreateOrder() {
		Order order = new Order();
		order.setMember(member);
		order.setTotal(35000);

		service.createOrder(order);
//
//		Order found = repository.findOne(order.getId());
//		assertThat(EqualsBuilder.reflectionEquals(found, order)).isTrue();

//		Member member = found.getMember();
//		assertThat(member.getOrders().contains(member)).isTrue();
	}

}