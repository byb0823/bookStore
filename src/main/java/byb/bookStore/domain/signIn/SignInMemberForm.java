package byb.bookStore.domain.signIn;

import byb.bookStore.domain.member.Gender;
import byb.bookStore.domain.member.Region;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInMemberForm {

    private Long memberId;

    @NotBlank
    private String id;

    @NotBlank
    private String password;

    @Email
    private String email;

    @NotBlank
    private String username;

    @Min(1)
    private int age;

    @NotBlank
    private Gender gender;

    @NotBlank
    private Region region;
}
