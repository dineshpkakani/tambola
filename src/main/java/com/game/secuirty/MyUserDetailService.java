package com.game.secuirty;

import com.game.entity.UserEntity;
import com.game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> user= userRepository.findByUserName(userName);
        user.orElseThrow(()->new UsernameNotFoundException("User not found::"+userName));
        return user.map(MyUserDetails::new).get();
    }
}
