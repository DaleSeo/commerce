package seo.dale.commerce.order;

import seo.dale.commerce.common.Model;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends Model {

	@Id @GeneratedValue
	private Long id;

	@ManyToOne
	private Member member;

	private double total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
