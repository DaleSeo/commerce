package seo.dale.commerce.core.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import seo.dale.commerce.common.Model;

import java.util.Collection;
import java.util.Collections;

/**
 * @author 서대영(DAEYOUNG SEO)/Onestore/SKP
 */
public class User extends Model implements UserDetails {

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new Role());
	}

	@Override
	public String getPassword() {
		return "1234";
	}

	@Override
	public String getUsername() {
		return "user";
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
