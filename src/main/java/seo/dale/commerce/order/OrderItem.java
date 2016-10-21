package seo.dale.commerce.order;

import seo.dale.commerce.common.BaseEntity;
import seo.dale.commerce.product.Product;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem extends BaseEntity {

	@ManyToOne
	private Order order;

	@ManyToOne
	private Product product;

	private Integer quantity;

	private Double price;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if (this.order == null) {

		}
		this.order = order;
		order.getOrderItems();
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
