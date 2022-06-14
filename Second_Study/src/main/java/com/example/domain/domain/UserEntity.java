package com.example.domain.domain;


import com.example.global.type.Sex;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String accountId;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 4, nullable = false)
    private Long studentId;

    @Enumerated(EnumType.STRING)
    @Column(length = 6, nullable = false)
    private Sex sex;

    @Builder
    public UserEntity(String accountId, String email, String password, String name, Long studentId, Sex sex) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.studentId = studentId;
        this.sex = sex;
    }

    public void update(String accountId, String email, String password, String name, Long studentId, Sex sex) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.studentId = studentId;
        this.sex = sex;
    }
}
