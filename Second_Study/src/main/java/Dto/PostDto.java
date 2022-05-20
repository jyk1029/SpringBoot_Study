package Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDto {
    private Long accountId;
    private String email;
    private String name;
    private String password;
    private Long studentId;
    private String sex;
}
