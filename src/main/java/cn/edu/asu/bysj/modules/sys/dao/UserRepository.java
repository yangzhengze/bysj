package cn.edu.asu.bysj.modules.sys.dao;

import cn.edu.asu.bysj.modules.sys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author asuy  2018.2.24
 * 用户
 *
 */
public interface UserRepository  extends JpaRepository<User,Long> {
    /**
     * 根据用户名查询用户
     * @return
     */
    User findByUsername(String userName);

    /**
     * 根据用户ID查询单个用户
     * @param user_id
     * @return
     * 开启nativeQuery=true，在value里可以用原生SQL语句完成查询
     */
    @Query(nativeQuery = true,value ="select * from  sys_user where user_id=:user_id")
    User findByUserId(@Param("user_id")Long user_id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value ="update sys_user set password=:newPasswd where user_id=:user_id")
    void  updatePassword(@Param("user_id")long user_id,@Param("newPasswd") String newPasswd);

}
