package cn.edu.asu.bysj.modules.sys.entity;

import java.util.List;

public class UserWithRole extends  User {
    private Integer RoleId;

    private List<Integer> roleIds;

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }
}
