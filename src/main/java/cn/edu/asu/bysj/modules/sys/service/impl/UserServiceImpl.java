package cn.edu.asu.bysj.modules.sys.service.impl;

import cn.edu.asu.bysj.common.util.MD5Utils;
import cn.edu.asu.bysj.modules.sys.dao.UserRepository;
import cn.edu.asu.bysj.modules.sys.dao.UserRoleRepository;
import cn.edu.asu.bysj.modules.sys.entity.User;
import cn.edu.asu.bysj.modules.sys.entity.UserRole;
import cn.edu.asu.bysj.modules.sys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author asuy 2018.4.24
 * 用户服务类--用户相关的业务
 */

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl  implements UserService{

    /** 注入UserRepository*/
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @Override
    public User findByName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public  User findById(Long userId) {
    //   Optional<User> user= userRepository.findById(userId);
       return userRepository.findByUserId(userId);
    }

    @Override
    public List<User> findUserWithDept(User user) {
       try {
          // return userRepository.findById();
           return null;
       }catch (Exception e){
           e.printStackTrace();
           return new ArrayList<User>();
       }

    }

    /**
      * 用户注册
     * @param user
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void registUser(User user) {
         user.setUser_create_time(new Date());
         user.setUser_theme(User.DEFAULT_THEME);
         user.setUser_sex(User.SEX_UNKNOW);
         user.setPassword(MD5Utils.encrypt(user.getUsername(),user.getPassword()));
         userRepository.save(user);
         //设置角色信息
        UserRole userRole =new UserRole();
         userRole.setUser_id(user.getUser_id());
        /**
         * 3:注册账户', '注册账户，只可查看，不可操作'
         */
        userRole.setRole_id(3L);
        userRoleRepository.save(userRole);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateTheme(String theme, String userName) {
        User user=findByName(userName);
        user.setUser_theme(theme);
        userRepository.save(user);
    }

    @Override
    public void addUser(User user, Long[] roles) {
           user.setUser_create_time(new Date());
           user.setUser_theme(User.DEFAULT_THEME);
           user.setUser_photo_url(User.DEFAULT_AVATAR);
           user.setPassword(MD5Utils.encrypt(user.getUsername(),user.getPassword()));
           userRepository.save(user);
           //设置权限
           for(Long roleId:roles){
               UserRole userRole =new UserRole();
                  userRole.setUser_id(user.getUser_id());
                  userRole.setRole_id(roleId);
                  userRoleRepository.save(userRole);
           }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateUser(User user, Long[] roles) {
            user.setUsername(null);
            user.setPassword(null);
            user.setUser_modify_time(new Date());
            userRepository.saveAndFlush(user);
            //先删除用户角色信息
            userRoleRepository.deleteById(user.getUser_id());
            //保存角色信息
            for(Long roleId:roles){
                UserRole userRole =new UserRole();
                 userRole.setUser_id(user.getUser_id());
                 userRole.setRole_id(roleId);
                 userRoleRepository.save(userRole);
            }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteUsers(String userIds) {
        List<String> lists = Arrays.asList(userIds.split(","));
       for(String list:lists){
           userRepository.findById(Long.valueOf(list));

       }
        userRepository.deleteAll();

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateLoginTime(String userName) {
        //查询出用户
        User user=findByName(userName);
        //更新用户时间
        user.setUser_lastlogin_time(new Date());
        userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updatePassword(String password) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String newPassword = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
        //user.setPassword(newPassword);
        userRepository.updatePassword(user.getUser_id(),newPassword);
    }

    @Override
    public User findUserProfile(User user) {

        return userRepository.findByUserId(user.getUser_id());
    }

    /**
     * 更新个人信息
     * @param user
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateUserProfile(User user) {
      User user1= userRepository.findByUserId(user.getUser_id());
        if (user.getDept_id() == null){
            user1.setDept_id(0l);
        }else {
            user1.setDept_id(user.getDept_id());
        }
       if(user.getUsername()!=null){
            user1.setUsername(user.getUsername());
       }
       if(user.getUser_sex()!=null){
            user1.setUser_sex(user.getUser_sex());
       }
       if(user.getUser_photo_url()!=null){
            user1.setUser_photo_url(user.getUser_photo_url());
       }
       if(user.getUser_realname()!=null){
            user1.setUser_realname(user.getUser_realname());
       }
       if(user.getEmail()!=null){
            user1.setEmail(user.getEmail());
       }
       if(user.getMobile()!=null){
            user1.setMobile(user.getMobile());
       }
       if(user.getUser_theme()!=null){
            user1.setUser_theme(user.getUser_theme());
       }
       if(user.getUser_description()!=null){
            user1.setUser_description(user.getUser_description());
       }
        this.userRepository.save(user1);
    }

    @Override
    public void savaUser(User user) {
        userRepository.save(user);
    }


}
