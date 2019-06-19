package com.sun.naruto.config;

import com.sun.naruto.domain.base.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author sunjian.
 */
@Component
public class NarutoDetailService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public NarutoDetailService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new User(username,
                        passwordEncoder.encode("123"),
                        AuthorityUtils.createAuthorityList("admin", "founder"));
    }
}
