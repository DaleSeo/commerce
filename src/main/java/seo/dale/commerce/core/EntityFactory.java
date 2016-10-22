package seo.dale.commerce.core;

import seo.dale.commerce.member.Member;
import seo.dale.commerce.order.Order;
import seo.dale.commerce.order.OrderItem;
import seo.dale.commerce.product.Product;

public class EntityFactory {

    public static Member newMember(String username, String password, String email) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setEmail(email);
        return member;
    }

    public static Product newProduct(String name, String description, Double price, Integer stock) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        return product;
    }

    public static Order newOrder(Member member, Double total) {
	    Order order = new Order();
	    order.setMember(member);
	    order.setTotal(total);
	    return order;
    }

    public static OrderItem newOrderItem(Order order, Product product, Double price) {
	    OrderItem orderItem = new OrderItem();
	    orderItem.setOrder(order);
	    orderItem.setProduct(product);
	    orderItem.setPrice(price);
	    return orderItem;
    }

}
