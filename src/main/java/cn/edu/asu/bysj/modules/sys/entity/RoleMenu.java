package cn.edu.asu.bysj.modules.sys.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色和菜单
 */
@Entity
@Table(name = "sys_role_menu")
public class RoleMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer sys_rolemenu_id;
    private Integer menu_id;

    private Integer role_id;

    public Integer getSys_rolemenu_id() {
        return sys_rolemenu_id;
    }

    public void setSys_rolemenu_id(Integer sys_rolemenu_id) {
        this.sys_rolemenu_id = sys_rolemenu_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
