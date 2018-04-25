package cn.edu.asu.bysj.modules.sys.entity;

import java.util.List;

public class RoleWithMenu extends Role {


    private Integer menuId;

    private List<Integer> menuIds;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
