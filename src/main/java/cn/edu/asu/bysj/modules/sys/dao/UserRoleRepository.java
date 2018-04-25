package cn.edu.asu.bysj.modules.sys.dao;

import cn.edu.asu.bysj.modules.sys.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户角色
 */
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
}
