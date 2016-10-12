package seo.dale.commerce.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import seo.dale.commerce.member.Member;
import seo.dale.commerce.member.MemberService;

import javax.annotation.PostConstruct;

@Component
@Profile("!production")
public class EntityInitializer {

    @Autowired
    private MemberService service;

    @PostConstruct
    public void initializer() {
        service.create(newMember(1L, "admin", "1234", "admin@commerce.com"));
        service.create(newMember(2L, "user", "1234", "use@commerce.com"));
        service.create(newMember(3L, "guest", "1234", "guest@commerce.com"));
    }

    private Member newMember(Long id, String username, String password, String email) {
        Member member = new Member();
        member.setId(id);
        member.setUsername(username);
        member.setPassword(password);
        member.setEmail(email);
        return member;
    }

}
