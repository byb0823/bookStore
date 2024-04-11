package byb.bookStore.web;

import byb.bookStore.domain.Login.LoginForm;
import byb.bookStore.domain.member.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String getLogin(@ModelAttribute("form") LoginForm form) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("form") LoginForm form, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/", value = "requestURL") String requestURL,
                        HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            log.error("loginBindingError={}", bindingResult);
            return "login";
        }

        Member loginMember = loginService.login(form.getUserId(), form.getPassword());
        if (loginMember == null) {
            bindingResult.reject("loginNotMatch", "아이디 또는 비밀번호가 일치하지 않습니다.");
            log.error("loginFail={}", bindingResult);
            return "login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("Member", loginMember);
        log.info("loginMember={}", loginMember);
        return "redirect:" + requestURL;
    }
}
