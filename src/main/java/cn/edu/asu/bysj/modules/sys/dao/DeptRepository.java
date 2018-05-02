package cn.edu.asu.bysj.modules.sys.dao;

import cn.edu.asu.bysj.modules.sys.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept,Long> {
    // 删除父节点，子节点变成顶级节点（根据实际业务调整）
   // void changeToTop(List<Integer> deptIds);
}
