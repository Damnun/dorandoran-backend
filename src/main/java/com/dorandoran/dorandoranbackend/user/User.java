package com.dorandoran.dorandoranbackend.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_account_id")
    private String accountId;

    @Column(name = "user_nickname")
    private String nickname;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_age")
    private Integer age;

    @Column(name = "user_sex")
    private String sex;

    @Column(name = "user_description")
    private String description;


    public User hashPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return this;
    }

    public boolean checkPassword(String plainPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(plainPassword, this.password);
    }
}
