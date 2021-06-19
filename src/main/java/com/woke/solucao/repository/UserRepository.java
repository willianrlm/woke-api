package com.woke.solucao.repository;

import com.woke.solucao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);
}