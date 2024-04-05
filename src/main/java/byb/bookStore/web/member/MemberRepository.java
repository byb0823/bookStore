package byb.bookStore.web.member;
import byb.bookStore.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class MemberRepository {
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public Member findById(Long id) {//sequence에서 저장되는 id를 뜻함
        return store.get(id);
    }

    public Member save(Member member) {
        member.setMemberId(++sequence);
        store.put(member.getMemberId(), member);
        log.info("member={}", member);
        return member;
    }

    public Optional<Member> findByMemberId(String id) {//로그인 시 사용
        return store.values().stream().filter(member -> member.getId().equals(id)).findFirst();
    }

}