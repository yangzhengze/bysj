package cn.edu.asu.bysj.modules.sys.entity;

import java.util.List;

public class UserWithRole extends  User {
    private Long RoleId;

    private List<Long> roleIds;

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
