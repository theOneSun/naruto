package com.sun.naruto.controller;

import com.sun.naruto.domain.base.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunjian.
 */
@RestController
public class LoginController {

    @RequestMapping("user/me")
    public User me(@AuthenticationPrincipal User me){
        return me;
    }
}
