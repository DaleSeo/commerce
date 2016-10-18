package seo.dale.commerce.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.member.MemberService;

@Service
public class AuthProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(AuthProvider.class);

	@Autowired
	private MemberService service;

	@Autowired
	public AuthProvider(MemberService service) {
		this.service = service;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		Member member = service.findByUsername(username);
		if (member == null) {
			throw new UsernameNotFoundException("Can't find the member with username, " + username);
		}

		if (!password.equals(member.getPassword())) {
			throw new BadCredentialsException("The password doesn't match.");
		}

		logger.info("The user has been authenticated successfully.");
		return new UsernamePasswordAuthenticationToken(username, password, AuthorityUtils.createAuthorityList("ROLE_USER"));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
