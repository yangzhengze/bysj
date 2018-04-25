package cn.edu.asu.bysj.modules.sys.dao;

import cn.edu.asu.bysj.modules.sys.entity.User;
import cn.edu.asu.bysj.modules.sys.entity.UserWithRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author asuy  2018.2.24
 * 用户
 *
 */
public interface UserRepository  extends JpaRepository<User,Integer> {
    /**
     * 根据用户名查询用户
     * @return
     */
    User findByUsername(String userName);

    //List<User> findByDeptName(User user);
//
//    List<UserWithRole> findUserWithRole(Long userId);
//
//    User findUserProfile(User user);
}
