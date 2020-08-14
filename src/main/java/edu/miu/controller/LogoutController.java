package edu.miu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@CrossOrigin
public class LogoutController {

    @Autowired
    ConsumerTokenServices consumerTokenServices;

    @Autowired
    private TokenStore tokenStore;

    @CrossOrigin
    @RequestMapping(value = "/logout/{token}", method = RequestMethod.GET)
    public String exit(@Valid @PathVariable("token") String token, HttpServletRequest request,
                       HttpServletResponse response, @RequestHeader("referer") String referer) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        SecurityContextHolder.getContext().setAuthentication(null);
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }

        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(accessToken);
        consumerTokenServices.revokeToken(accessToken.getValue());

        return "redirect:" + referer;
    }
}
