package seo.dale.commerce.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    public void create(Member member) {
        repository.save(member);
    }

    public void modify(Long id, Member member) {
        member.setId(id);
        repository.save(member);
    }

    public void remove(Long id) {
        repository.delete(id);
    }

    public Member detail(Long id) {
        return repository.findOne(id);
    }

    public List<Member> list() {
        return repository.findAll();
    }

}
