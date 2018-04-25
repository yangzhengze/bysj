package cn.edu.asu.bysj.modules.sys.service;

import cn.edu.asu.bysj.modules.sys.entity.User;

import java.util.List;

public interface UserService  {
   // UserWithRole findById(Long userId);

    /**
     * 通过用户名查找用户信息
     * @param userName
     * @return
     */
    User findByName(String userName);

    /**
     * 用户部门信息
     * @param user
     * @return
     */
    List<User> findUserWithDept(User user);

    /**
     * 用户注册
     * @param user
     */
    void registUser(User user);

    /**
     * 更新主题
     * @param theme
     * @param userName
     */
    void updateTheme(String theme, String userName);

    /**
     * 增加用户
     * @param user
     * @param roles
     */
    void addUser(User user, Integer[] roles);

    /**
     * 更新用户
     * @param user
     * @param roles
     */
    void updateUser(User user, Integer[] roles);

    /**
     * 删除用户
     * @param userIds
     */
    void deleteUsers(String userIds);

    /**
     * 更新用户登录时间
     * @param userName
     */

    void updateLoginTime(String userName);

    /**
     * 更新用户密码
     * @param password
     */
    void updatePassword(String password);

    /**
     * 查询用户个人描述
     * @param user
     * @return
     */
    User findUserProfile(User user);

    /**
     * 更新个人描述
     * @param user
     */
    void updateUserProfile(User user);
}
