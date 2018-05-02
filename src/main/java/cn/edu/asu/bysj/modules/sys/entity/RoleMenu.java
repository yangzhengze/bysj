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
    private  Long sys_rolemenu_id;
    private Long menu_id;

    private Long role_id;

    public Long getSys_rolemenu_id() {
        return sys_rolemenu_id;
    }

    public void setSys_rolemenu_id(Long sys_rolemenu_id) {
        this.sys_rolemenu_id = sys_rolemenu_id;
    }

    public Long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
