package seo.dale.commerce.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.member.MemberService;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MemberService memberService;

	public void createOrder(Order order) {
		Member member = order.getMember();
		if (member == null) {
			throw new OrderException("Can't create order without the member.");
		}
		member = memberService.detail(member.getId());
		order.setMember(member);
		orderRepository.save(order);
	}

}
