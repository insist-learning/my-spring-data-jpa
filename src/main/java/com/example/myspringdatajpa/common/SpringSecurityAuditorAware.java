package com.example.myspringdatajpa.common;

import com.example.myspringdatajpa.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
public class SpringSecurityAuditorAware implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        User user = new User();
        user.setId(1L);
        user.setName("Test");
        return Optional.of(user);
    }
}
