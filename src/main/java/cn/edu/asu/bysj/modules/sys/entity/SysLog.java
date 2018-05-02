package cn.edu.asu.bysj.modules.sys.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sys_log")
public class SysLog implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long syslog_id;

    //操作用户ID
    private Long user_id;

    @Transient
    private  String option_userName;

    //操作描述
    private  String operation;

    //请求方法
    private  String method;

    //请求参数
    private  String params;

    //执行时间 执行时长(毫秒)
    private  Long runtime;

    //IP
    private  String ip;

    //操作时间
    private Date syslog_create_date;

    //操作地点
    private  String syslog_location;

    // 用于搜索条件中的时间字段
    @Transient
    private String timeField;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getSyslog_id() {
        return syslog_id;
    }

    public void setSyslog_id(Long syslog_id) {
        this.syslog_id = syslog_id;
    }

    public String getOption_userName() {
        return option_userName;
    }

    public void setOption_userName(String option_userName) {
        this.option_userName = option_userName==null?null:option_userName.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation==null?null:operation.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method==null?null:method.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params==null?null:params.trim();
    }

    public Long getRuntime() {
        return runtime;
    }

    public void setRuntime(Long runtime) {
        this.runtime = runtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip==null?null:ip.trim();
    }

    public Date getSyslog_create_date() {
        return syslog_create_date;
    }

    public void setSyslog_create_date(Date syslog_create_date) {
        this.syslog_create_date = syslog_create_date;
    }

    public String getSyslog_location() {
        return syslog_location;
    }

    public void setSyslog_location(String syslog_location) {
        this.syslog_location = syslog_location;
    }

    public String getTimeField() {
        return timeField;
    }

    public void setTimeField(String timeField) {
        this.timeField = timeField;
    }
}
