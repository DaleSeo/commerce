package seo.dale.commerce.member.service;

import org.springframework.stereotype.Service;
import seo.dale.commerce.member.model.Member;

import java.util.List;

@Service
public class MemberService {

    public Long create(Member member) {
        return -1L;
    }

    public void modify(Long id, Member member) {
    }

    public void remove(Long id) {

    }

    public Member detail(Long id) {
        Member member = new Member();
        member.setEmail("dale.seo@gmail.com");
        member.setUsername("dale0713");
        member.setPassword("12345678");
        return member;
    }

    public List<Member> list() {
        return null;
    }

}
