package byb.bookStore.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Member {

    private Long memberId;

    private String id;

    private String password;

    private String email;

    private String username;

    private int age;

    private Gender gender;

    private Region region;

    public Member(String id, String password, String email, String username, int age, Gender gender, Region region) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.region = region;
    }
}
