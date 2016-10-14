package seo.dale.commerce.core.auth;

import org.springframework.security.core.GrantedAuthority;
import seo.dale.commerce.common.Model;

public class Role extends Model implements GrantedAuthority {

	@Override
	public String getAuthority() {
		return "USER";
	}

}
