package com.devopsbuddy.backend.service;

import com.devopsbuddy.backend.persistence.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Donald F. Coffin on 5/31/17.
 */
@Service
public class UserSecurityService implements UserDetailsService {

    /** The application logger **/
    private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.devopsbuddy.backend.persistence.domain.backend.User user = userRepository.findByUsername(username);
        if (null == user) {
            LOG.warn("Username {} not found!!", username);
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return user;
    }
}
