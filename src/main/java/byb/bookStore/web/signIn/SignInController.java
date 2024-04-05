package byb.bookStore.web.signIn;

import byb.bookStore.domain.member.Member;
import byb.bookStore.domain.member.Region;
import byb.bookStore.domain.signIn.SignInMemberForm;
import byb.bookStore.web.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Controller
@RequiredArgsConstructor
public class SignInController {

    private final MemberRepository memberRepository;

    @ModelAttribute("regions")
    public List<Region> regions() {
        List<Region> list = new ArrayList<>();
        list.add(new Region("S", "서울"));
        list.add(new Region("K", "경기"));
        return list;
    }

    @GetMapping("/signIn")
    public String getSignInPage(@ModelAttribute("form") SignInMemberForm form) {
        return "signIn";
    }

    @PostMapping("/signIn")
    public String signIn(@Validated @ModelAttribute("form") SignInMemberForm form, BindingResult bindingResult) {

        if (form.getPassword() != null) {
            if (form.getPassword().length() < 5) {
                bindingResult.rejectValue("password", "five");
            }
        }

        if (bindingResult.hasFieldErrors()) {
            log.error("error={}", bindingResult.getFieldError());
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
        memberRepository.save(member);

        return "home";
    }
}
