package byb.bookStore.web;

import byb.bookStore.domain.member.Member;
import byb.bookStore.web.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        return memberRepository.findByMemberId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
}
