package library.controller;

import library.model.Member;
import library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController

public class MemberController {

    private MemberService memberService;
    private final AtomicLong membercounter = new AtomicLong();

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    @RequestMapping("/members")
    public List<Member> listMembers() {
        return (List<Member>) memberService.listMembers();
    }

    @GetMapping
    @RequestMapping("/registermembers")
    public Member registerMember(@RequestParam(value = "name", defaultValue = " ") String name, @RequestParam(value = "embg", defaultValue = " ") String embg) {
        Member member = new Member(membercounter.incrementAndGet(), name, embg);
        return this.memberService.registerMember(member);
    }

    @GetMapping
    @RequestMapping("/members/books")
    public Member lendBook(@PathVariable("membername") String memberName, @PathVariable("bookname") String bookName) {
        return memberService.lendBook(memberName, bookName);
    }
}