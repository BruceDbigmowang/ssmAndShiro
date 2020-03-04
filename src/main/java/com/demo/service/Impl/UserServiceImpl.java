package com.demo.service.Impl;

import com.demo.mapper.UsersMapper;
import com.demo.pojo.Users;
import com.demo.pojo.UsersExample;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UsersMapper usersMapper;

    @Override
    public Users login(String account) {
        UsersExample example = new UsersExample();
        example.createCriteria().andUserNameEqualTo(account);
        List<Users> users = usersMapper.selectByExample(example);
        if(users.size()!=0){
            return users.get(0);
        }else{
            return null;
        }
    }
}
