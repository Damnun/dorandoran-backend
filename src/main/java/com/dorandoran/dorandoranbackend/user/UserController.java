package com.dorandoran.dorandoranbackend.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public String create(@RequestParam @Nullable String userName, String nickName, Integer age, @Nullable String sex,
                         String password, String description, @Nullable String hobit, String accountId) {
        User user = new User();
        user.setAccountId(accountId);
        user.setPassword(password);
        user.setName(userName);
        user.setNickname(nickName);
        user.setAge(age);
        user.setSex(sex);
        user.setDescription(description);
        user.setHobit(hobit);

        Long id = userService.saveUser(user);

        // @TODO : farm_id 생성

        return id + "번 유저 등록 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer id) {
        userService.removeUser(id);
        return id + "번 유저 삭제 완료";
    }

    @GetMapping("/findUserById")
    public User findUserById(@RequestParam Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/findUserByUserId")
    public Optional<User> findUserByUserId(@RequestParam String userId) {
        return userService.findUserByUserId(userId);
    }

    @GetMapping("/findUserByUserAccountId")
    public Optional<User> findUserByUserAccountId(@RequestParam String accountId) {
        return userService.findUserByUserAccountId(accountId);
    }

    @GetMapping("/findAllUsers")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/login")
    public Object login(@RequestParam String userId, String password) {
        Optional<User> user = userService.findUserByUserId(userId);

        if (user.isPresent()) {
            if (user.get().checkPassword(password, passwordEncoder)) {
                return user.get().getId();
            }
            return "패스워드가 틀립니다.";
        }
        return "아이디에 해당되는 유저가 존재하지 않습니다.";
    }


    @PostMapping("/setUserPasswordByUserId")
    public String setUserPasswordByUserId(@RequestParam Integer userId, String password) {
        userService.setUserPasswordByUserId(userId, password);
        return userId + "번 유저의 패스워드를 변경합니다.";
    }
}
