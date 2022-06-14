package Dto;

import com.example.SpringBoot.Sex;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
