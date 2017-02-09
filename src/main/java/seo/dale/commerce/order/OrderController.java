package seo.dale.commerce.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody Order order) {
		service.create(order);
		return order.getId();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order detail(@PathVariable Long id) {
		return service.detail(id);
	}

	@RequestMapping
	public List<Order> list() {
		return service.list();
	}

}
