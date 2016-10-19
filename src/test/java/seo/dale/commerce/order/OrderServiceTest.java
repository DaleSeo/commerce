package seo.dale.commerce.order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import seo.dale.commerce.core.ModelFactory;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.member.MemberService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

	@Mock
	private OrderRepository repository;

	@Mock
	private MemberService memberService;

	@InjectMocks
	private OrderService service;

	private Order order;

	@Before
	public void setUp() {
		Member member = ModelFactory.newMember("user", "", "");
		when(memberService.detail(1L)).thenReturn(member);
		when(repository.save(any(Order.class))).thenReturn(order);

		order = new Order();
		order.setMember(new Member(1L));
		order.setTotal(35000);
	}

	@Test
	public void testCreateOrder() {
		Member member = ModelFactory.newMember("user", "", "");
		when(memberService.detail(1L)).thenReturn(member);

		Order out = new Order();
		out.setMember(member);
		out.setTotal(35000);
		when(repository.save(any(Order.class))).thenReturn(out);

		Order in = new Order();
		in.setMember(new Member(1L));
		in.setTotal(35000);

		service.createOrder(in);
	}

}