package dto;

import com.example.SpringBoot.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostEditDto {
    private String accountId;
    private String password;
    private String email;
    private String name;
    private Long studentId;
    private Sex sex;
}
