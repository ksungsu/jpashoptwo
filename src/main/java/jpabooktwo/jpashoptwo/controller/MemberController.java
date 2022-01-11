package jpabooktwo.jpashoptwo.controller;

import jpabooktwo.jpashoptwo.domain.Address;
import jpabooktwo.jpashoptwo.domain.Member;
import jpabooktwo.jpashoptwo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result){ //렌더링한 MemberForm이 파라미터로 넘어오게된다.

        //error 발생 시
        if(result.hasErrors()){
            return "members/createMemberForm";
        }

        //Address 객체 생성
        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        //member 이름 및 주소 삽입 및 저장
        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);
        memberService.join(member);

        // return(redirect)
         return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
