package seo.dale.commerce.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seo.dale.commerce.member.Member;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public void createOrder(Order order) {
		Member member = order.getMember();
		if (member == null) {
			throw new OrderException("Can't create order without the member.");
		}
		orderRepository.save(order);
	}

}
