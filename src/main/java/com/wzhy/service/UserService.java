package com.wzhy.service;

import com.wzhy.mapper.UserMapper;
import com.wzhy.pojo.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
//        String id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(id);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

}
