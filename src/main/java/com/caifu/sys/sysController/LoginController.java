package com.caifu.sys.sysController;

import com.caifu.common.Result;
import com.caifu.common.ResultUtil;
import com.caifu.pojo.SysUser;
import com.caifu.service.SysMenuService;
import com.caifu.service.SysUserService;
import com.caifu.util.ShiroUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Lyf
 * @Date: 2020/7/3 19:57
 * @Description:
 */
@Controller
public class LoginController extends AbstractController{

    final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysMenuService menuService;

    @Autowired
    private SysUserService userService;

    @RequestMapping(value = {"","/","/login","login"})
    public String login(){
        return "view/sys/login";
    }

    @RequestMapping("/authentication")
    @ResponseBody
    public JSONObject authentication(SysUser user){
        JSONObject obj = new JSONObject();
        int code = 200;
        String msg = "登陆成功！";
        Subject subject = SecurityUtils.getSubject();
        try {
            if (!subject.isAuthenticated()){
                UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                        user.getLoginName(),
                        user.getPassword()
                );
                subject.login(usernamePasswordToken);
                subject.getSession().setTimeout(1800000);
                userService.updateLoginTime(user.getLoginName());
            }
        } catch (AuthenticationException e) {
            code = 101;
            msg = "账号或密码错误！";
        } catch (AuthorizationException e) {
            msg = "没有权限";
            code = 102;
        } catch (Exception e) {
            e.printStackTrace();
        }
        obj.put("code",code);
        obj.put("msg",msg);
        return obj;
    }

    @RequestMapping("/index")
    public String index(ModelMap model){
        SysUser user = getUser();
        model.put("userName",user.getUserName());
        return "view/sys/index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "view/sys/welcome";
    }

    @RequestMapping("/getMenuByUser")
    @ResponseBody
    public Result getMenuByUser() throws Exception{
        try{
            Object obj = menuService.getMenuByUser(getUser().getUserNo());
            return ResultUtil.success("data",obj);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取用单失败！");
            throw new Exception("获取用单失败！");
        }
    }

    //退出登录
    @RequestMapping("/outLogin")
    public String outLogin(){
        ShiroUtil.logout();
        return "redirect:login";
    }
}
