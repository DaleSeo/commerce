package seo.dale.commerce.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Member detail(@PathVariable Long id) {
        return service.detail(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Member> list() {
        return service.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.remove(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Member member) {
        service.create(member);
        return member.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modify(@PathVariable Long id, @RequestBody Member member) {
        service.modify(id, member);
    }

}
