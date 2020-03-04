package com.demo.service.Impl;

import com.demo.mapper.FunctionsMapper;
import com.demo.mapper.RoleAndFunctionMapper;
import com.demo.mapper.RoleMapper;
import com.demo.mapper.UserAndRoleMapper;
import com.demo.pojo.*;
import com.demo.service.FunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class FunctionServiceImpl implements FunctionService {
    @Resource
    FunctionsMapper functionsMapper;
    @Resource
    UserAndRoleMapper userAndRoleMapper;
    @Resource
    RoleMapper roleMapper;
    @Resource
    RoleAndFunctionMapper roleAndFunctionMapper;

    @Override
    public List<Functions> findByUserId(int user_id) {
        UserAndRoleExample userAndRoleExample = new UserAndRoleExample();
        userAndRoleExample.createCriteria().andUserIdEqualTo(user_id);
        List<UserAndRoleKey> roles = userAndRoleMapper.selectByExample(userAndRoleExample);
        List<Functions> functionsList = new ArrayList<Functions>();
        if (roles.size() != 0) {
            for (int i = 0; i < roles.size(); i++) {
                int role_id = roles.get(i).getRoleId();
                RoleAndFunctionExample roleAndFunctionExample = new RoleAndFunctionExample();
                roleAndFunctionExample.createCriteria().andRoleIdEqualTo(role_id);
                List<RoleAndFunctionKey> functions = roleAndFunctionMapper.selectByExample(roleAndFunctionExample);
                if (functions.size() != 0) {
                    for (int j = 0; j < functions.size(); j++) {
                        int functionId = functions.get(j).getFuncId();
                        Functions function = functionsMapper.selectByPrimaryKey(functionId);
                        functionsList.add(function);
                    }
                }
            }
        }
        return functionsList;
    }

    @Override
    public List<Role> getRoleByUserId(int user_id) {
        UserAndRoleExample userAndRoleExample = new UserAndRoleExample();
        userAndRoleExample.createCriteria().andUserIdEqualTo(user_id);
        List<UserAndRoleKey> roles = userAndRoleMapper.selectByExample(userAndRoleExample);
        List<Role> roleList = new ArrayList<Role>();
        if (roles.size() != 0) {
            for (int i = 0; i < roles.size(); i++) {
                int role_id = roles.get(i).getRoleId();
                Role role = roleMapper.selectByPrimaryKey(role_id);
                roleList.add(role);
            }
        }
        return roleList;
    }
}
