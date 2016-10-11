package seo.dale.commerce.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seo.dale.commerce.member.model.Member;
import seo.dale.commerce.member.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Member detail(@PathVariable Long id) {
        return service.detail(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long create(@RequestBody Member member) {
        return 1L;
    }


}
