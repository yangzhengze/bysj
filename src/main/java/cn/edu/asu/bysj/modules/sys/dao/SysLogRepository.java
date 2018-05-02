package cn.edu.asu.bysj.modules.sys.dao;

import cn.edu.asu.bysj.modules.sys.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 系统日志
 */
public interface SysLogRepository extends JpaRepository<SysLog,Long>{
}
