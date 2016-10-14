package seo.dale.commerce.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import seo.dale.commerce.member.MemberService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Enumeration;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private MemberService service;

    @RequestMapping("/signIn")
    public void signIn(Principal principal, HttpSession session) {
	    System.out.println("> principal : " + principal);
	    Enumeration<String> attributeNames = session.getAttributeNames();

	    while (attributeNames.hasMoreElements()) {
			String name = attributeNames.nextElement();
		    Object value = session.getAttribute(name);
		    System.out.println("> " + name + ": " + value);
	    }

	    UserDetails user = new User();
	    Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());

	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    securityContext.setAuthentication(authentication);

        // Member member = service.detail(1L);
    }

    @RequestMapping("/signOut")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signOut(HttpSession session) {
        session.invalidate();
    }

}
