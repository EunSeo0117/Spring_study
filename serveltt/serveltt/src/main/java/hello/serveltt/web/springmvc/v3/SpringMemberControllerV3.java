package hello.serveltt.web.springmvc.v3;

import hello.serveltt.domain.member.Member;
import hello.serveltt.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping(value = "/new-form", method = RequestMethod.GET) //매핑방식은 여러개다
    public String  newForm() {
        return "new-form";

    }

    //members경로이므로 추가로 붙일거없음
    @PostMapping("/save")//단순조회는 get 데이터변경 post
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username,age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
}
