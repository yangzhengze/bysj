package cn.edu.asu.bysj.modules.sys.dao;

import cn.edu.asu.bysj.modules.sys.entity.Role;
import cn.edu.asu.bysj.modules.sys.entity.RoleWithMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer>{
//    List<Role> findUserRole(String userName);
//
//    List<RoleWithMenu> findById(Long roleId);
}
