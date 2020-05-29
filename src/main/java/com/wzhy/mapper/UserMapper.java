package com.wzhy.mapper;

import com.wzhy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public User loadUserByUsername(String username);
    public int insertUser(User user);

}
