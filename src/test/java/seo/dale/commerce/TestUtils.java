package seo.dale.commerce;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import seo.dale.commerce.core.EntityFactory;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.order.Order;
import seo.dale.commerce.product.Product;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

	public static Member persistTestMember(TestEntityManager entityManager) {
		return entityManager.persist(EntityFactory.newMember("user", "", ""));
	}

	public static Product persistTestProduct(TestEntityManager entityManager) {
		return persistTestProduct(entityManager, 0);
	}

	public static Product persistTestProduct(TestEntityManager entityManager, int id) {
		List<Product> productList = new ArrayList<>();
		productList.add(EntityFactory.newProduct("Apple", "Red apple", 1000.1, 100));
		productList.add(EntityFactory.newProduct("Banana", "Yellow banana", 2000.0, 1000));
		return entityManager.persist(productList.get(id));
	}

	public static Order persistTestOrder(TestEntityManager entityManager) {
		Order order = new Order();
		order.setTotal(35000);
		return entityManager.persist(order);
	}

}
