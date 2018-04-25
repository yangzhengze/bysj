package cn.edu.asu.bysj.modules.sys.entity;


import javax.persistence.*;

/**
 * 系统字典实体
 */
@Entity
@Table(name = "sys_dict")
public class Dict {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dict_id;

    //字典名称
    private  String dict_name;

    //字典类型
    private  String dict_type;

    //字典码值
    private  String dict_code;

    //数据字典值
    private  String dict_value;

    //数据字典字段名称
    private  String dict_filed_name;

    //数据字典表名称
    private  String dict_table_name;

    //数据字典排序
    private  Integer dict_order=0;

    //数据字典备注
    private  String dict_remark;

    //数据字典删除标记 删除标记  -1：已删除  0：正常
    private  Integer dict_del_flag=0;

    public Integer getDict_id() {
        return dict_id;
    }

    public void setDict_id(Integer dict_id) {
        this.dict_id = dict_id;
    }

    public String getDict_name() {
        return dict_name;
    }

    public void setDict_name(String dict_name) {
        this.dict_name = dict_name;
    }

    public String getDict_type() {
        return dict_type;
    }

    public void setDict_type(String dict_type) {
        this.dict_type = dict_type;
    }

    public String getDict_code() {
        return dict_code;
    }

    public void setDict_code(String dict_code) {
        this.dict_code = dict_code;
    }

    public String getDict_value() {
        return dict_value;
    }

    public void setDict_value(String dict_value) {
        this.dict_value = dict_value;
    }

    public String getDict_filed_name() {
        return dict_filed_name;
    }

    public void setDict_filed_name(String dict_filed_name) {
        this.dict_filed_name = dict_filed_name==null?null:dict_filed_name.trim();
    }

    public String getDict_table_name() {
        return dict_table_name;
    }

    public void setDict_table_name(String dict_table_name) {
        this.dict_table_name = dict_table_name==null?null:dict_table_name.trim();
    }

    public Integer getDict_order() {
        return dict_order;
    }

    public void setDict_order(Integer dict_order) {
        this.dict_order = dict_order;
    }

    public String getDict_remark() {
        return dict_remark;
    }

    public void setDict_remark(String dict_remark) {
        this.dict_remark = dict_remark;
    }

    public Integer getDict_del_flag() {
        return dict_del_flag;
    }

    public void setDict_del_flag(Integer dict_del_flag) {
        this.dict_del_flag = dict_del_flag;
    }
}
