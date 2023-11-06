package inflearn.mvc.basic.hello.controller;

import inflearn.mvc.basic.hello.domain.Member;
import inflearn.mvc.basic.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("memberServie" + memberService.getClass());
    }

    @GetMapping("/member/new")
    public String creaerForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/member/new")
    public String create(MemberForm memberForm) {
        Member member = new Member();
        member.setName("test");
        memberService.join(member);

        return "redirect:/";
    }


}
