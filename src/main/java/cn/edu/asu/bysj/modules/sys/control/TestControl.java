package cn.edu.asu.bysj.modules.sys.control;

import cn.edu.asu.bysj.modules.sys.dao.UserRepository;
import cn.edu.asu.bysj.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class TestControl {

    @Autowired
    private UserRepository userRepository1;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String name,
                                           @RequestParam String password){
        User user=new User();
        user.setUsername(name);
        user.setPassword(password);
        userRepository1.save(user);
        return "添加成功";
    }


    @GetMapping(path = "/list")
    public @ResponseBody Iterable<User> getALLUsers(){
        return  userRepository1.findAll();
    }
}
