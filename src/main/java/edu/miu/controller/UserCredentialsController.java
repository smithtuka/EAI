package edu.miu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.miu.domain.UserCredentials;
import edu.miu.service.UserCredentialsService;

@RestController
@CrossOrigin
@RequestMapping({"/userCredentials"})
public class UserCredentialsController {

    @Autowired
    UserCredentialsService credentialsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody List<UserCredentials>  findAll( ) {
        return  credentialsService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserCredentials findOne(@PathVariable("id") String userName ) {
        UserCredentials validCredentials = credentialsService.findByUserName(userName);
        return  validCredentials;
    }


}
