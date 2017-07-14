package seo.dale.commerce.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

	@OneToMany(fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<OrderItem> orderItems = new ArrayList<>();

	private double total;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		if (this.member != null) {
			this.member.getOrders().remove(this);
		}
		this.member = member;
		if (!this.member.getOrders().contains(this)) {
			this.member.getOrders().add(this);
		}
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public int sizeOrderItems() {
		if (orderItems == null) {
			return 0;
		}
		return orderItems.size();
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
