package com.shadowapp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shadowapp.entity.User;
import com.shadowapp.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    
    

    public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPasswordHash())
//                .authorities(user.getRole()) // "ROLE_USER" or "ROLE_ADMIN"
                .build();
    }
}
