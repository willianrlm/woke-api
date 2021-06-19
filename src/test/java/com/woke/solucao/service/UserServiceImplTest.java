package com.woke.solucao.service;

import com.woke.solucao.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserServiceImplTest {
    @Test
    @DisplayName("Teste de serviço de usuário")
    void testUserServiceImpl(){
        UserServiceImpl userService = new UserServiceImpl(null);
    }
}