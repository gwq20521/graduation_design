/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * copyright: 2018
 */
package com.design.graduation.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import com.design.graduation.model.DeptPerm;
import com.design.graduation.model.Employee;
import com.design.graduation.model.Permission;
import com.design.graduation.service.DeptPermService;
import com.design.graduation.service.EmployeeService;
import com.design.graduation.service.JobposService;
import com.design.graduation.service.PermissionService;
import com.design.graduation.util.ReturnData;

/**
 * @className: com.design.graduation.security.SecurityRealm
 * @description: TODO - 
 * @author: 郭伟强   E-mail:gwq20521@163.com
 * @createTime: 2018年3月9日 上午11:34:27 
 * @version: v 1.0
 * @since 
 *
 */
@Component("securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Resource
    private EhCacheManager cacheManager;

    //@Resource
    //private HashedCredentialsMatcher credentialsMatcher;

    @Resource
    private EmployeeService employeeService;

    @Resource
    private JobposService jobposService;

    @Resource
    private DeptPermService deptPermService;

    @Resource
    private PermissionService permissionService;

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginname = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());

        Employee employee = new Employee();
        employee.setLoginname(loginname);
        employee.setPassword(password);

        ReturnData rd = employeeService.selectByParam(null, employee);
        Employee currentEmp = null;
        if ("OK".equals(rd.getCode())) {
            List<Employee> emps = (List<Employee>) rd.getData().get("data");
            if (emps.size() == 1) {
                currentEmp = emps.get(0);
            }
        }

        if (currentEmp == null) {
            throw new AuthenticationException("用户名或密码错误.");
        }

        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("current_emp", currentEmp);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(currentEmp, currentEmp.getPassword(),
                getClass().getName());

        return authenticationInfo;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = String.valueOf(principals.getPrimaryPrincipal());

        //使用shiro cache
        Cache<String, SimpleAuthorizationInfo> userAuthori = this.cacheManager.getCache("MyAuthorizationInfo");

        //获取权限
        SimpleAuthorizationInfo authorizationInfo = userAuthori.get(username + "_permissions");

        //不为空的时候直接返回，否则进行查询
        if (authorizationInfo != null) {
            return authorizationInfo;
        }

        authorizationInfo = new SimpleAuthorizationInfo();

        //Subject subject = SecurityUtils.getSubject();
        //Map<?, ?> user = (Map<?, ?>) subject.getSession().getAttribute("AccountInfo");

        //根据账号ID查出账号对于的角色
        /*List<Map<?, ?>> permInfos = new ArrayList<Map<?, ?>>();
        Set<String> perms = new HashSet<String>();
        for (Map<?, ?> perm : permInfos) {
            perms.add(perm.get("MENUCODE").toString());
        }*/

        Subject subject = SecurityUtils.getSubject();

        Employee currentEmp = (Employee) subject.getSession().getAttribute("current_emp");

        int deptId = jobposService.selectDeptIdById(currentEmp.getJobposId());

        DeptPerm deptPerm = new DeptPerm();
        deptPerm.setDeptId(deptId);
        ReturnData rdDeptPerm = deptPermService.selectByParam(null, deptPerm);
        List<DeptPerm> deptPermList = (List<DeptPerm>) rdDeptPerm.getData().get("data");

        List<Integer> permIdList = new ArrayList<Integer>();

        for (int i = 0; i < deptPermList.size(); i++) {
            permIdList.add(deptPermList.get(i).getPermId());
        }

        if (permIdList.size() > 0) {
            String permIdStr = permIdList.toString();
            permIdStr = permIdStr.substring(1, permIdStr.length() - 1);
            ReturnData rdPermission = permissionService.selectByPermIds(permIdStr);
            List<Permission> permList = (List<Permission>) rdPermission.getData().get("data");

            for (int i = 0; i < permList.size(); i++) {
                authorizationInfo.addStringPermission(permList.get(i).getPercode());
            }
        }

        userAuthori.put(username + "_permissions", authorizationInfo);

        return authorizationInfo;
    }
}
