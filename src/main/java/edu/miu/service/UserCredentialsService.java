package edu.miu.service;

import edu.miu.domain.UserCredentials;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserCredentialsService extends UserDetailsService {
    List<UserCredentials> findAll();
    UserCredentials findByUserName(String username);
}
