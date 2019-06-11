package com.sun.naruto.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunjian.
 */
@RestController
public class LoginController {

    @RequestMapping("user/me")
    public UserDetails me(@AuthenticationPrincipal UserDetails me){
        return me;
    }
}
