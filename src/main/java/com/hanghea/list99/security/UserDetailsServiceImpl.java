package com.hanghea.list99.security;

import com.hanghea.list99.domain.User;
import com.hanghea.list99.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service         //로그인 요청이 왔을때 , 실행이된다.
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + userId));

        return new UserDetailsImpl(user);
    }


//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserDetailsServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        User user = userRepository.findUserByUserId(userId)
//                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + userId));
//
//        return new UserDetailsImpl(user);
//    }
}
