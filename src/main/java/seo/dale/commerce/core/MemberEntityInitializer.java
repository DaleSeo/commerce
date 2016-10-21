package seo.dale.commerce.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import seo.dale.commerce.member.MemberService;

import javax.annotation.PostConstruct;

@Component
@Profile("!production")
public class MemberEntityInitializer {

    @Autowired
    private MemberService service;

    @PostConstruct
    public void initializer() {
        service.create(EntityFactory.newMember("admin", "1234", "admin@commerce.com"));
        service.create(EntityFactory.newMember("user", "1234", "use@commerce.com"));
        service.create(EntityFactory.newMember("guest", "1234", "guest@commerce.com"));
    }

}
