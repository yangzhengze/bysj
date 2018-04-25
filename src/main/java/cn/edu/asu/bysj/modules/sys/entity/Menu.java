package cn.edu.asu.bysj.modules.sys.entity;



import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单实体
 */
@Entity
@Table(name="sys_menu")
public class Menu implements Serializable {

    public static final String TYPE_CONTENT = "0";
    public static final String TYPE_MENU = "1";
    public static final String TYPE_BUTTON = "2";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer menu_id;
    //父级菜单ID
    private Integer mparent_id;

    //菜单名称
    private  String menu_name;

    //菜单URL
    private  String menu_url;

    //菜单权限
    private  String menu_perms;

    //菜单类型 类型   0：目录   1：菜单   2：按钮
    private  Integer menu_type;
   //菜单图标
    private  String  menu_icon;

    //菜单排序
    private  Integer menu_order;

    //菜单创建时间
    private Date menu_create_time;

    //修改菜单时间
    private  Date menu_modify_time;

    public static String getTypeContent() {
        return TYPE_CONTENT;
    }

    public static String getTypeMenu() {
        return TYPE_MENU;
    }

    public static String getTypeButton() {
        return TYPE_BUTTON;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getMparent_id() {
        return mparent_id;
    }

    public void setMparent_id(Integer mparent_id) {
        this.mparent_id = mparent_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = (null==menu_name?"":menu_name.trim());
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = (null==menu_url?"":menu_url.trim());
    }

    public String getMenu_perms() {
        return menu_perms;
    }

    public void setMenu_perms(String menu_perms) {
        this.menu_perms = (null==menu_perms?"":menu_perms.trim());
    }

    public Integer getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(Integer menu_type) {
        this.menu_type = menu_type;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = (null==menu_icon?"":menu_icon.trim());
    }

    public Integer getMenu_order() {
        return menu_order;
    }

    public void setMenu_order(Integer menu_order) {
        this.menu_order = menu_order;
    }

    public Date getMenu_create_time() {
        return menu_create_time;
    }

    public void setMenu_create_time(Date menu_create_time) {
        this.menu_create_time = menu_create_time;
    }

    public Date getMenu_modify_time() {
        return menu_modify_time;
    }

    public void setMenu_modify_time(Date menu_modify_time) {
        this.menu_modify_time = menu_modify_time;
    }
}
