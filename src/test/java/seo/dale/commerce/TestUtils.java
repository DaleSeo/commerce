package seo.dale.commerce;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import seo.dale.commerce.core.ModelFactory;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.order.Order;
import seo.dale.commerce.product.Product;

public class TestUtils {

	public static Member persistTestMember(TestEntityManager entityManager) {
		return entityManager.persist(ModelFactory.newMember("user", "", ""));
	}

	public static Product persistTestProduct(TestEntityManager entityManager) {
		Product product = ModelFactory.newProduct("Apple", "Red apple", 1000.1, 100);
		return entityManager.persist(product);
	}

	public static Order persistTestOrder(TestEntityManager entityManager) {
		Order order = new Order();
		order.setTotal(35000);
		return entityManager.persist(order);
	}

}
