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
    private Integer sys_roledept_id;
    private Integer role_id;

    private Integer dept_id;

    public Integer getSys_roledept_id() {
        return sys_roledept_id;
    }

    public void setSys_roledept_id(Integer sys_roledept_id) {
        this.sys_roledept_id = sys_roledept_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }
}
