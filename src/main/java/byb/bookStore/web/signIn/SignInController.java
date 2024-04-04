package byb.bookStore.web.signIn;

import byb.bookStore.domain.member.Member;
import byb.bookStore.domain.member.Region;
import byb.bookStore.domain.signIn.SignInMemberForm;
import byb.bookStore.web.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class SignInController {

    private final MemberRepository memberRepository;

    @ModelAttribute("regions")
    public List<Region> regions() {
        List<Region> list = new ArrayList<>();
        list.add(new Region("S", "서울"));
        list.add(new Region("K", "경기"));
        return regions();
    }

    @GetMapping("/signIn")
    public String getSignInPage(@ModelAttribute("form") SignInMemberForm form) {
        return "signIn";
    }

    @PostMapping("/signIn")
    public String signIn(@Validated @ModelAttribute("form") SignInMemberForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signIn";
        }

        Member member = new Member(
                form.getId(),
                form.getPassword(),
                form.getEmail(),
                form.getUsername(),
                form.getAge(),
                form.getGender(),
                form.getRegion()
        );

        //Todo
        //repository에 저장

        return "home";
    }
}
