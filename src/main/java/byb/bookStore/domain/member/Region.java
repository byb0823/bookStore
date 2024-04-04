package byb.bookStore.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Region {

    //(S, 서울), (K, 경기)
    private String code;
    private String name;
}
