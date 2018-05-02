package cn.edu.asu.bysj.modules.sys.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户实体
 * @author asuy
 *
 */
@Entity
@Table(name = "sys_user")
public class User implements Serializable{

    /**
     * 账户有效
     */
    public static final Integer STATUS_VALID = 1;
    /**
     * 账户锁定
     */
    public static final Integer STATUS_LOCK = 0;

    public static final String  SEX_UNKNOW = "2";
    //主题
    public static final String DEFAULT_THEME = "green";
    //头像
    public static final String DEFAULT_AVATAR = "default.jpg";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long user_id;    //@Column(name = "user_id")
    //部门id
    private Long dept_id;

    //部门名称
    @Transient //在表中不存在的字段
    private String deptName;

    //用户名
    private  String username;
    //密码
    private  String password;
    //加密盐
    private  String salt;
    //用户实际的名字
    private  String user_realname;
    //用户性别 0 男, 1女
    private String  user_sex;
    //电子邮件
    private  String email;
    //手机号
    private  String mobile;
    //使用状态 状态：0：禁用   1：正常,
    private  Integer status=STATUS_VALID;
    //创建用户时间
    private Date user_create_time;
    //修改用户时间
    private  Date user_modify_time;
     //最近登录时间
    private  Date user_lastlogin_time;
     //用户的主题
    private  String user_theme;
    //用户的头像
    private  String user_photo_url;
     //用户自我简介
    private  String user_description;
    //角色名称
    @Transient //  //在表中不存在的字段
    private String roleName;


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = (null==username?null:username.trim());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = (null==password?null:password.trim());
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email =( null==email?null:email.trim());
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = (null==mobile?null:mobile.trim());
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUser_create_time() {
        return user_create_time;
    }

    public void setUser_create_time(Date user_create_time) {
        this.user_create_time = user_create_time;
    }


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public Date getUser_modify_time() {
        return user_modify_time;
    }

    public void setUser_modify_time(Date user_modify_time) {
        this.user_modify_time = user_modify_time;
    }

    public Date getUser_lastlogin_time() {
        return user_lastlogin_time;
    }

    public void setUser_lastlogin_time(Date user_lastlogin_time) {
        this.user_lastlogin_time = user_lastlogin_time;
    }

    public String getUser_theme() {
        return user_theme;
    }

    public void setUser_theme(String user_theme) {
        this.user_theme = user_theme;
    }

    public String getUser_photo_url() {
        return user_photo_url;
    }

    public void setUser_photo_url(String user_photo_url) {
        this.user_photo_url = user_photo_url;
    }

    public String getUser_description() {
        return user_description;
    }

    public void setUser_description(String user_description) {
        this.user_description = user_description;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
