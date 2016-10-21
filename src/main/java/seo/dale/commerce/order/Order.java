package seo.dale.commerce.order;

import seo.dale.commerce.common.BaseEntity;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@ManyToOne
	private Member member;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();

	private double total;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		if (member != null) {
			member.getOrders().remove(this);
		}
		this.member = member;
		if (!member.getOrders().contains(this)) {
			member.getOrders().add(this);
		}
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public boolean containOrderItem(OrderItem orderItem) {
		return orderItems.contains(orderItem);
	}

	public boolean removeOrderItem(OrderItem orderItem) {
		return orderItems.remove(orderItem);
	}

	public boolean addOrderItem(OrderItem orderItem) {
		return orderItems.add(orderItem);
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Product> getProduts() {
		return null;
	}

	public Double getTotal() {
		return 0.0;
	}

}
