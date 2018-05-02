package cn.edu.asu.bysj.modules.sys.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户和角色表
 *
 */
@Entity
@Table(name = "sys_user_role")
public class UserRole implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sys_userrole_id;
    private Long user_id;

    private  Long  role_id;

    public Long getSys_userrole_id() {
        return sys_userrole_id;
    }

    public void setSys_userrole_id(Long sys_userrole_id) {
        this.sys_userrole_id = sys_userrole_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
