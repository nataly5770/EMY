package com.eventmanagment.event.service;

import com.eventmanagment.event.model.Authorities;
import com.eventmanagment.event.model.User;
import com.eventmanagment.event.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUsers = userRepository.findById(username);
        if (!optionalUsers.isPresent())
            throw new UsernameNotFoundException("User not found");

        User users = optionalUsers.get();
        return new org.springframework.security.core.userdetails.User(
                users.getUsername(),
                users.getPassword(),
                getGrantedAuthorities(users.getAuthorities())

        );
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<Authorities> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authorities authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return grantedAuthorities;
    }


}
