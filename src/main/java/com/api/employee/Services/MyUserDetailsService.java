package com.api.employee.Services;

import java.util.Optional;

import com.api.employee.Entity.User;
import com.api.employee.UserDetails.MyUserDetails;
import com.api.employee.dao.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByuserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found " + userName));
        return user.map(MyUserDetails::new).get();
    }

}
