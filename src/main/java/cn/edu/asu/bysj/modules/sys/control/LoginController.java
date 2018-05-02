package cn.edu.asu.bysj.modules.sys.control;

import cn.edu.asu.bysj.common.annotation.Log;
import cn.edu.asu.bysj.common.control.BaseController;
import cn.edu.asu.bysj.common.util.MD5Utils;
import cn.edu.asu.bysj.common.util.vcode.Captcha;
import cn.edu.asu.bysj.common.util.vcode.GifCaptcha;
import cn.edu.asu.bysj.modules.sys.entity.User;
import cn.edu.asu.bysj.modules.sys.service.UserService;
import org.apache.commons.lang.StringUtils;
import cn.edu.asu.bysj.common.domain.ResponseBo;
import cn.edu.asu.bysj.modules.sys.dao.UserRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 登录控制类
 */
@Controller
public class LoginController extends BaseController{
    @Autowired
   private UserService userService;

    @GetMapping(path = "/login")
    public  String login(){
        return "login";
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public ResponseBo login(@RequestParam String username, @RequestParam String password, @RequestParam String code, @RequestParam Boolean rememberMe){
        if(!StringUtils.isNotBlank(code)){
            return ResponseBo.warn("验证码不能为空");
        }
        Session session=super.getSession();
        String sessionCode = (String) session.getAttribute("_code");
        if (!code.toLowerCase().equals(sessionCode)) {
            return ResponseBo.warn("验证码错误！");
        }
        password = MD5Utils.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            super.login(token);
            //更新登录时间
            userService.updateLoginTime(username);
            return ResponseBo.ok();
        } catch (UnknownAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseBo.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }

    }
    @GetMapping(value = "gifCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            Captcha captcha = new GifCaptcha(146, 33, 4);
            captcha.out(response.getOutputStream());
            Session session = super.getSession();
            session.removeAttribute("_code");
            session.setAttribute("_code", captcha.text().toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping(path = "/403")
    public String forbid() {
        return "403";
    }

    @Log("访问系统")
    @RequestMapping("/index")
    public String index(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "index";
    }
}
