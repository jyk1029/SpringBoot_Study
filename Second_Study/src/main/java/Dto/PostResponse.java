package Dto;

import com.example.SpringBoot.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponse {

    private final String accountId;
    private final String name;
    private final String email;
    private final Long studentId;
    private final String password;
    private final Sex sex;

}
