package edu.miu.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @CrossOrigin
    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }
}
