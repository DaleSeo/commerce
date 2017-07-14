package seo.dale.commerce.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import seo.dale.commerce.member.Member;

import java.util.Arrays;
import java.util.List;

/**
 * @author 서대영(DAEYOUNG SEO)/Onestore/SKP
 */
@RestController
public class MemberTestController {

	@PostMapping("/members")
	@ResponseStatus(HttpStatus.CREATED)
	public void post(@RequestBody Member member) {
		System.out.println("#member:" + member);
	}

	@GetMapping("/members")
	public List<Member> get() {
		return Arrays.asList(new Member());
	}

}
