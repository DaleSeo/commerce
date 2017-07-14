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

	@GetMapping()
	public List<Member> list() {
		return service.list();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody Member member) {
		service.create(member);
		return member.getId();
	}

	@GetMapping(value = "/{id}")
    public Member detail(@PathVariable Long id) {
        return service.detail(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.remove(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modify(@PathVariable Long id, @RequestBody Member member) {
        service.modify(id, member);
    }

}
