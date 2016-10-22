package seo.dale.commerce.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public void create(Order order) {
		if (order.getMember() == null) {
			throw new OrderException("Can't create order without the member.");
		}
		if (order.sizeOrderItems() < 1) {
			throw new OrderException("Can't create order without any order items.");
		}
		orderRepository.save(order);
	}

	public Order detail(Long id) {
		Order order = orderRepository.findOne(id);
		return order;
	}

}
