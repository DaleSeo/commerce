package seo.dale.commerce.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.member.MemberRepository;
import seo.dale.commerce.order.Order;
import seo.dale.commerce.order.OrderItem;
import seo.dale.commerce.order.OrderItemRepository;
import seo.dale.commerce.order.OrderRepository;
import seo.dale.commerce.product.Product;
import seo.dale.commerce.product.ProductRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@Profile("!production")
public class EntityInitializer {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private ProductRepository productRepository;


	@PostConstruct
    public void initialize() {
	    Member[] members = new Member[3];
	    members[0] = memberRepository.save(EntityFactory.newMember("user", "1234", "user@commerce.com"));
	    members[1] = memberRepository.save(EntityFactory.newMember("admin", "1234", "admin@commerce.com"));
	    members[2] = memberRepository.save(EntityFactory.newMember("guest", "1234", "guest@commerce.com"));

	    Product[] products = new Product[3];
	    products[0] = productRepository.save(EntityFactory.newProduct("Apple", "Red apple", 1000.0, 100));
	    products[1] = productRepository.save(EntityFactory.newProduct("Banana", "Yellow banana", 2000.0, 1000));
	    products[2] = productRepository.save(EntityFactory.newProduct("Mellon", "Green mellon", 500.0, 500));

	    Order[] orders = new Order[1];
		orders[0] = orderRepository.save(EntityFactory.newOrder(members[0], 3500.0));

	    OrderItem[] orderItems = new OrderItem[2];
	    orderItems[0] = orderItemRepository.save(EntityFactory.newOrderItem(orders[0], products[0], 1000.0));
		orderItems[1] = orderItemRepository.save(EntityFactory.newOrderItem(orders[0], products[1], 2000.0));

		entityManager.clear();
    }

}
