package Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class LogInDto {
    private String accountId;
    private String password;
}
