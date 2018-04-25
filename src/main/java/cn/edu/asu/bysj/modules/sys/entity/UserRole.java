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
    private Integer sys_userrole_id;
    private Integer user_id;

    private  Integer  role_id;

    public Integer getSys_userrole_id() {
        return sys_userrole_id;
    }

    public void setSys_userrole_id(Integer sys_userrole_id) {
        this.sys_userrole_id = sys_userrole_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
