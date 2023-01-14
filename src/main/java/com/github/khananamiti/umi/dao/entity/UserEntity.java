package com.github.khananamiti.umi.dao.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class UserEntity {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String login;
    private final String email;
    private final String password;
}
