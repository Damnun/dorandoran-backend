package com.dorandoran.dorandoranbackend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public Long saveUser(User user) {
        user.hashPassword(bCryptPasswordEncoder);
        userRepository.save(user);
        return user.getId();
    }

    public void setUserPasswordByUserId(Integer userId, String password) {
        userRepository.setUserPasswordByUserId(userId, bCryptPasswordEncoder.encode(password));
    }

    public void removeUser(Integer id) {
        userRepository.remove(id);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }


    public Optional<User> findUserByUserAccountId(String accountId) {
        return userRepository.findByUserAccountId(accountId);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
}
