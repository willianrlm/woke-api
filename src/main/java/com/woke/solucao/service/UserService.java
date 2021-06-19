package com.woke.solucao.service;

import com.woke.solucao.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service{

    List<User> findAll();

    Optional<User> findById(Long id);

    User findByLogin(String login);

    User save(User u);
}