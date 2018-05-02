package cn.edu.asu.bysj.modules.sys.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体
 */
@Entity
@Table(name="sys_role")
public class Role implements Serializable{
    //角色ID
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long role_id;  //@Column(name = "role_id")

    //角色名称
    private  String role_name;

    //角色说明
    private  String role_remark;

    //创建角色时间
    private Date role_create_time;

    //角色修改时间
    private  Date role_modify_time;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_remark() {
        return role_remark;
    }

    public void setRole_remark(String role_remark) {
        this.role_remark = (null==role_remark?null:role_remark.trim());
    }

    public Date getRole_create_time() {
        return role_create_time;
    }

    public void setRole_create_time(Date role_create_time) {
        this.role_create_time = role_create_time;
    }

    public Date getRole_modify_time() {
        return role_modify_time;
    }

    public void setRole_modify_time(Date role_modify_time) {
        this.role_modify_time = role_modify_time;
    }
}
