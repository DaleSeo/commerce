package seo.dale.commerce.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import seo.dale.commerce.common.BaseEntity;
import seo.dale.commerce.order.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {

	@Column(unique = true)
    private String username;
    private String password;

    private String email;

	@OneToMany
//	@JsonBackReference
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();

	public Member() {
	}

	public Member(Long id) {
		super(id);
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public List<Order> getOrders() {
		return orders;
	}

}
