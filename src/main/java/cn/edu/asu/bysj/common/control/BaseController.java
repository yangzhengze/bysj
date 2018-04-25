package cn.edu.asu.bysj.common.control;
import java.util.HashMap;
import java.util.Map;

import cn.edu.asu.bysj.modules.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

//import com.github.pagehelper.PageInfo;

public class BaseController {
    /**
     * 分页插件pagehelper
     * @return
     */
//    protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
//        Map<String, Object> rspData = new HashMap<String, Object>();
//        rspData.put("rows", pageInfo.getList());
//        rspData.put("total", pageInfo.getTotal());
//        return rspData;
//    }
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }
    protected User getCurrentUser() {
        return (User) getSubject().getPrincipal();
    }

    protected Session getSession() {
        return getSubject().getSession();
    }

    protected Session getSession(Boolean flag) {
        return getSubject().getSession(flag);
    }

    protected void login(AuthenticationToken token) {
        getSubject().login(token);
    }
}
