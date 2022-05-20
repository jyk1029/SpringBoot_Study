package com.example.SpringBoot;

import com.example.SpringBoot.domain.PostEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
public class PostResponse {
   private final Long accountId;
   private final String name;
   private final String email;
   private final Long studentId;
   private final String password;
   private final String sex;
}
