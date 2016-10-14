package seo.dale.commerce.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import seo.dale.commerce.member.Member;
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

        Member member = service.detail(1L);
        session.setAttribute(Member.class.getSimpleName(), member);
    }

    @RequestMapping("/signOut")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signOut(HttpSession session) {
        session.invalidate();
    }

}
