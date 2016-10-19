package seo.dale.commerce.member;

import seo.dale.commerce.common.Model;
import seo.dale.commerce.order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends Model {

    @Id @GeneratedValue
    private Long id;

	@Column(unique = true)
    private String username;
    private String password;

    private String email;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();

	public Member() {
	}

	public Member(Long id) {
		this.id = id;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
