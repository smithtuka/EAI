package edu.miu.service.impl;

import edu.miu.dao.UserCredentialsDao;
import edu.miu.domain.UserCredentials;
import edu.miu.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class UserCredentialsServiceImpl implements UserCredentialsService {
    @Autowired
    UserCredentialsDao userCredentialsDao;

    @Override
    public List<UserCredentials> findAll() {
        return userCredentialsDao.findAll();
    }

    @Override
    public UserCredentials findByUserName(String username) {
        return userCredentialsDao.findByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserCredentials userCredentials = null;

        try {
            System.out.println("Username: " + s);
            userCredentials = userCredentialsDao.findByUserName(s);
            UserCredentials finalUserCredentials = userCredentials;
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return null;
                }

                @Override
                public String getPassword() {
                    return finalUserCredentials.getPassword();
                }

                @Override
                public String getUsername() {
                    return finalUserCredentials.getUserName();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return false;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return false;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return false;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("User " + s + " was not found in the database");
            throw new UsernameNotFoundException("User " + s + " was not found in the database");
        }
    }
}
