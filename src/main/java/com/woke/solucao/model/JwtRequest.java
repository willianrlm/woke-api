package com.woke.solucao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@AllArgsConstructor
public class JwtRequest  {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}