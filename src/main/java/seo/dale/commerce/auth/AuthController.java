package seo.dale.commerce.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @RequestMapping("/signIn")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signIn(@RequestParam String username, @RequestParam String password) {
	    Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
	    authentication = manager.authenticate(authentication);
	    SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @RequestMapping("/signOut")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signOut() {
	    SecurityContextHolder.clearContext();
    }

}
