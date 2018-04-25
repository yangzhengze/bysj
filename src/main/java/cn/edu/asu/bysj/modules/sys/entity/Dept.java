package cn.edu.asu.bysj.modules.sys.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 部门实体表
 */
@Entity
@Table(name = "sys_dept")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer dept_id;

    //上级部门ID
    private  Integer dparent_id;

    //部门名称
    private  String dept_name;

    //排序
    private  Integer order_num;

    //部门创建时间
    private Date dept_create_time;

    //删除标记 是否删除  -1：已删除  0：正常
    private  Integer del_flag=0;

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getDparent_id() {
        return dparent_id;
    }

    public void setDparent_id(Integer dparent_id) {
        this.dparent_id = dparent_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = (null==dept_name?null:dept_name.trim());
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public Date getDept_create_time() {
        return dept_create_time;
    }

    public void setDept_create_time(Date dept_create_time) {
        this.dept_create_time = dept_create_time;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }
}
