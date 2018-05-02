package cn.edu.asu.bysj.modules.sys.entity;



import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色和部门的关系表
 */
@Entity
@Table(name = "sys_role_dept")
public class RoleDept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sys_roledept_id;
    private Long role_id;

    private Long dept_id;

    public Long getSys_roledept_id() {
        return sys_roledept_id;
    }

    public void setSys_roledept_id(Long sys_roledept_id) {
        this.sys_roledept_id = sys_roledept_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }
}
