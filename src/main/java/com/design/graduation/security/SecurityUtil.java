/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * copyright: 2018
 */
package com.design.graduation.security;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * @className: com.design.graduation.security.SecurityRealm
 * @description: TODO - 
 * @author: 郭伟强   E-mail:gwq20521@163.com
 * @createTime: 2018年3月9日 上午11:34:27 
 * @version: v 1.0
 * @since 
 *
 */
@Component("securityUtil")
public class SecurityUtil {

    @Resource
    private SecurityRealm securityRealm;

    @Resource
    private EhCacheManager cacheManager;

    public void reloadAuthorizing(Integer deptId) {
        Cache<String, SimpleAuthorizationInfo> userAuthori = cacheManager.getCache("MyAuthorizationInfo");

        //获取权限
        SimpleAuthorizationInfo authorizationInfo = userAuthori.get(deptId + "_permissions");

        //不为空的时候直接返回，否则进行查询
        if (authorizationInfo != null) {
            //清空缓存
            userAuthori.remove(deptId + "_permissions");

            //userAuthori.clear();

            //cacheManager.getCacheManager().removeCache("MyAuthorizationInfo");

            //清空认证
            //securityRealm.getAuthorizationCache().remove(deptId + "_permissions");

            Subject subject = SecurityUtils.getSubject();
            String realmName = subject.getPrincipals().getRealmNames().iterator().next();
            //第一个参数为用户名,第二个参数为realmName,test想要操作权限的用户
            SimplePrincipalCollection principals = new SimplePrincipalCollection(deptId + "_permissions", realmName);
            subject.runAs(principals);

            securityRealm.getAuthorizationCache().remove(subject.getPrincipals());

            //刷新认证资源
            subject.releaseRunAs();
        }
    }

    /** 
     * 重新赋值权限(在比如:给一个角色临时添加一个权限,需要调用此方法刷新权限,否则还是没有刚赋值的权限) 
     * @param myRealm 自定义的realm 
     * @param username 用户名 
     */
    public void reloadAuthorizing() {
        /*Subject subject = SecurityUtils.getSubject();
        
        String username = String.valueOf(principals.getPrimaryPrincipal());
        
        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
        //第一个参数为用户名,第二个参数为realmName,test想要操作权限的用户   
        SimplePrincipalCollection principals = new SimplePrincipalCollection(username, realmName);
        
        subject.runAs(principals);
        securityRealm.getAuthorizationCache().remove(subject.getPrincipals());
        subject.releaseRunAs();*/

        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principals = subject.getPrincipals();
        String username = String.valueOf(principals.getPrimaryPrincipal());
        Cache<String, SimpleAuthorizationInfo> userAuthori = cacheManager.getCache("MyAuthorizationInfo");

        //获取权限
        SimpleAuthorizationInfo authorizationInfo = userAuthori.get(username + "_permissions");

        //不为空的时候直接返回，否则进行查询
        if (authorizationInfo != null) {
            userAuthori.remove(username + "_permissions");

            /*securityRealm.getAuthorizationCache().remove(principals);
            subject.releaseRunAs();*/

            /*Employee currentEmp = (Employee) subject.getSession().getAttribute("current_emp");
            
            int jobposId = currentEmp.getJobposId();
            
            int deptId = jobposService.selectDeptIdById(jobposId);
            
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
                    String percode = permList.get(i).getPercode();
                    //System.out.println(percode);
            
                    //只有部门经理以上的级别的职位拥有任务分配的权限 - 10  任务分配    1   jobs_manage_show    jobs_manage/show    6   1
                    if ("jobs_manage_show".equals(percode)) {
                        String jobposCode = jobposService.selectCodeById(jobposId);
                        if (jobposCode.length() <= 6) {
                            authorizationInfo.addStringPermission(percode);
                        }
                    }
                    else {
                        authorizationInfo.addStringPermission(percode);
                    }
                }
            }
            
            userAuthori.put(username + "_permissions", authorizationInfo);*/
        }
    }

    /** 
     * 清空所有关联认证 
     */
    /*public void clearAllCachedAuthorizationInfo2() {
        Cache<Object, AuthorizationInfo> cache = securityRealm.getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                System.out.println(key + ":" + key.toString());
                cache.remove(key);
            }
        }
    }*/

}
