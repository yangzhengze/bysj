package cn.edu.asu.bysj.modules.sys.service;

import cn.edu.asu.bysj.modules.sys.entity.UserOnline;
import java.util.List;

/**
 * 记录session
 * @author asuy 2018.4.24
 */
public interface  SessionService {
    /**
     * 列出在线用户
     * @return
     */
    List<UserOnline> list();

    /**
     * 用户强制下线
     * @param sessionId
     * @return
     */
    boolean forceLogout(String sessionId);
}
