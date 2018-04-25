package cn.edu.asu.bysj;

import cn.edu.asu.bysj.modules.sys.entity.User;
import cn.edu.asu.bysj.modules.sys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BysjApplicationTests {
	@Autowired
	UserService userService;
//	@Test
////	public void contextLoads() {
////	}
	@Test
	public void testStartJob() throws Exception {
		//12\
		User user=new User();
		user=userService.findByName("tester");
		System.out.println(user.getUsername());
	}

}
