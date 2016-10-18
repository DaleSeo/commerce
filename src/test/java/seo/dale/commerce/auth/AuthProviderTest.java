package seo.dale.commerce.auth;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import seo.dale.commerce.core.ModelFactory;
import seo.dale.commerce.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthProviderTest {

	private AuthProvider provider;

	private MemberService service;

	@Before
	public void setUp() {
		service = mock(MemberService.class);
		when(service.findByUsername("guest")).thenReturn(ModelFactory.newMember("guest", "1234", "guest@commerce.com"));

		provider = new AuthProvider(service);
	}

	@Test
	public void testAuthenticate() {
		Authentication user = new TestingAuthenticationToken("guest", "1234");
		Authentication result = provider.authenticate(user);

		assertThat(result.getName()).isEqualTo(user.getName());
		assertThat(result.getCredentials()).isEqualTo(user.getCredentials());
		assertThat(result.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
	}

	@Test(expected = UsernameNotFoundException.class)
	public void testAuthenticateThrowUsernameNotFoundException() {
		Authentication user = new TestingAuthenticationToken("guest1", "1234");
		provider.authenticate(user);
		fail("should have thrown a UsernameNotFoundException");
	}

	@Test(expected = BadCredentialsException.class)
	public void testAuthenticateThrowBadCredentialsException() {
		Authentication user = new TestingAuthenticationToken("guest", "5678");
		provider.authenticate(user);
		fail("should have thrown a BadCredentialsException");
	}

}