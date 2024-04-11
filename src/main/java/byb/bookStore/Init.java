package byb.bookStore;

import byb.bookStore.domain.member.Gender;
import byb.bookStore.domain.member.Member;
import byb.bookStore.domain.member.Region;
import byb.bookStore.web.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Init {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member member = new Member(
                "test",
                "qwer",
                "q@q",
                "testUser",
                20,
                Gender.M,
                "S");
        memberRepository.save(member);
    }
}
