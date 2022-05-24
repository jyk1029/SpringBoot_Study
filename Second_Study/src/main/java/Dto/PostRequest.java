package Dto;

import com.example.SpringBoot.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class PostRequest {
    @NotBlank(message = "id에는 Null이 들어가면 안됩니다.")
    private String accountId;
    @NotBlank(message = "password에는 Null이 들어가면 안됩니다.")
    private String password;
    private String name;
    private String email;
    private Long studentId;
    private Sex sex;
}
