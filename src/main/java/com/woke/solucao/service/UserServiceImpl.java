package com.woke.solucao.service;

import com.woke.solucao.model.User;
import com.woke.solucao.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl implements UserService {
    private final UserRepository userRepository;

    private static final String userFailAuth = "Id passado por parâmetro não corresponde ao usuário logado";

    public Boolean validateUser(User user) {

        //Test validation
        if(user == null){
            return false;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        if(!user.getLogin().equals(currentPrincipalName)){
            throw new SecurityException(userFailAuth);
        }

        if(user.getPassword() == null || user.getPassword().isEmpty()){
            User u = userRepository.findByLogin(user.getLogin());
            user.setPassword(u.getPassword());
        }
        return true;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        if (validateUser(user)) {

            return userRepository.save(user);
        }
        return new User();
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
