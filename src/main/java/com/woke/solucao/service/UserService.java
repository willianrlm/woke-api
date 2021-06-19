package com.woke.solucao.service;

import com.woke.solucao.model.User;

public interface UserService extends Service{
    User findByLogin(String login);

    User save(User u);
}