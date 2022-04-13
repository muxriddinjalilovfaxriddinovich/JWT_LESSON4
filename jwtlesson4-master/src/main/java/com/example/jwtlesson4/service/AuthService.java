package com.example.jwtlesson4.service;

import com.example.jwtlesson4.entity.User;
import com.example.jwtlesson4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (User user : userRepository.findAll()) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        throw new UsernameNotFoundException("User topilmadi");
    }



}
