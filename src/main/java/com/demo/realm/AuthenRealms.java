package com.demo.realm;

import com.demo.pojo.Functions;
import com.demo.pojo.Role;
import com.demo.pojo.Users;
import com.demo.pojo.UsersExample;
import com.demo.service.FunctionService;
import com.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class AuthenRealms extends AuthorizingRealm {
    @Resource
    UserService userService;
    @Resource
    FunctionService functionService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取数据库权限
        Users user = (Users)principalCollection.getPrimaryPrincipal();
        System.out.println(user.getUserId());
        List<String> perms = new ArrayList<String>();
        /*List<String> roles = new ArrayList<String>();*/
        //根据用户信息获取所属于的角色，
       /* List<Role> roleList = functionService.getRoleByUserId(user.getUserId());
        if(roleList != null || "".equals(roleList)){
            for(Role role:roleList){
                roles.add(role.getRoleName());
            }
        }*/
        // 根据用户信息查询所拥有的的权限
        List<Functions> functions = functionService.findByUserId(user.getUserId());

        if(functions != null || "".equals(functions)){
            for(Functions function:functions){
                perms.add(function.getFuncCode());
            }
        }
        System.out.println(perms);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(perms);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证AuthorizingRealm
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名名称
        String username = authenticationToken.getPrincipal().toString();
        //通过用户名获取用户对象
        Users user = userService.login(username);
        //把user对象封装的AuthenticationInfo中返回
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword().toString(),ByteSource.Util.bytes(user.getSalt()),"authenRealm");
        return authenticationInfo;
    }
}
