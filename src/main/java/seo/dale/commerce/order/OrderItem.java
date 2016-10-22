package seo.dale.commerce.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import seo.dale.commerce.common.BaseEntity;
import seo.dale.commerce.product.Product;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem extends BaseEntity {

	@ManyToOne
	@JsonBackReference
	private Order order;

	@ManyToOne
	@JsonBackReference
	private Product product;

	private Integer quantity;

	private Double price;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if (this.order != null) {
			this.order.removeOrderItem(this);
		}
		this.order = order;
		if (this.order.containOrderItem(this)) {
			this.order.addOrderItem(this);
		}
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
