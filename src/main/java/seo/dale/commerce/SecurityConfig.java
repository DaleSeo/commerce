package seo.dale.commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import seo.dale.commerce.auth.AuthProvider;

@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthProvider authProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth
		    .authenticationProvider(authProvider)
		    .inMemoryAuthentication()
		    .withUser("user").password("password").roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/").permitAll()
		        .antMatchers("/api/auth/signIn").permitAll()
		        .antMatchers("/api/auth/signOut").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/record").permitAll()
                .antMatchers("/api/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
            .httpBasic();
    }

}
