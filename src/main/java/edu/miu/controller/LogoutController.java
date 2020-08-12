package edu.miu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@FrameworkEndpoint
public class LogoutController {

    @Autowired
    AuthorizationServerTokenServices authorizationServerTokenServices;

    @Autowired
    ConsumerTokenServices consumerTokenServices;

    @RequestMapping("/doLogout")
    public String exit(@RequestParam("token") String tokenId, HttpServletRequest request,
                       @RequestHeader("referer") String referer) {

        consumerTokenServices.revokeToken(tokenId);
        new SecurityContextLogoutHandler().logout(request, null, null);
        return "redirect:" + referer;
    }
}
