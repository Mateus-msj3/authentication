package com.dev.authentication;

import com.dev.authentication.model.User;
import com.dev.authentication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class AuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            initCreateUser(userRepository, passwordEncoder);
//        };
//    }
//
//    private void initCreateUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        User admin = new User();
//        admin.setEmail("admin@dev.com");
//        admin.setName("Admin");
//        admin.setPassword(passwordEncoder.encode("admin"));
//
//        Optional<User> find = userRepository.findByEmail("admin@email.com");
//        if (find == null) {
//            userRepository.save(admin);
//        }
//        userRepository.save(admin);
//    }
}

