package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
//    private final MemberService memberService = new MemberService();  New 하는 것이 아닌 스프링 컨테이너에 등록해서 쓰기
    private final MemberService memberService;

    @Autowired  // 알아서 스프링 컨테이너와 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
