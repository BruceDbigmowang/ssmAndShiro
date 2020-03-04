package com.demo.service;

import com.demo.pojo.Functions;
import com.demo.pojo.Role;

import java.util.List;

public interface FunctionService {
    public List<Functions> findByUserId(int user_id);
    public List<Role> getRoleByUserId(int user_id);
}
