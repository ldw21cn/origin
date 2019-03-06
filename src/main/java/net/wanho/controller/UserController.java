package net.wanho.controller;

import com.alibaba.fastjson.JSONObject;
import net.wanho.entity.User;
import net.wanho.service.UserService;
import net.wanho.system.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*M*

 */
@Controller
@SessionAttributes(value ={"user"} )
public class UserController{


    Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;




    @RequestMapping(value = "/user/select", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectUser() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<User> userlist = new ArrayList<>();
            jsonObject.put("status", 200);
            jsonObject.put("list", userlist);
        } catch (Exception e) {
            jsonObject.put("status", 400);
        }
        return jsonObject;
    }


    /**
     * 用户注册
     * @param
     * @return
     */
    @RequestMapping("/user/register")
    @ResponseBody
    public JSONObject register(@RequestParam("account") String account,@RequestParam("firstPasswd") String firstPasswd,@RequestParam("retypePasswd") String retypePasswd)
    {

        JSONObject jsonObject = new JSONObject();


        if(StringUtils.isEmpty(account)||StringUtils.isEmpty(firstPasswd)||StringUtils.isEmpty(retypePasswd))
        {
            jsonObject.put("status",400);
            jsonObject.put("msg","账号或者密码输入为空，请检验");
            return jsonObject;
        }

        //判断两次输入密码是否相同
        if(!firstPasswd.equals(retypePasswd))
        {
            jsonObject.put("status",400);
            jsonObject.put("msg","输入的密码不相同，请检验");
            return jsonObject;
        }

        //判断账号不存在
        if(userService.fetchUserByAccount(account)!=null)
        {
            jsonObject.put("status",400);
            jsonObject.put("msg","该账号已经存在，请重新输入账号");
            return jsonObject;
        }

        User user = new User();
        user.setAccount(account);
        user.setPasswd(firstPasswd);

        if(userService.addUser(user))
        {
            jsonObject.put("status",200);
        }
        return jsonObject;
    }

    @RequestMapping("/user/login")
    public String login(@Valid User user, ModelMap modelMap,BindingResult bindingResult)
    {

        if(StringUtils.isEmpty(user.getAccount())||StringUtils.isEmpty(user.getPasswd()))
        {
            return "loginerror";
        }

        User user1 = userService.fetchUserByAccount(user.getAccount());
        if(StringUtils.isEmpty(user1))
        {
            return "loginerror";
        }

        if(!user1.getPasswd().equals(user.getPasswd()))
        {
            return "loginerror";
        }


        try
        {
            user1.setLastLoginDate(new Date());
            userService.updateUser(user1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            logger.error("更新用户最近登录时间失败："+user1.toString());
        }
        user1.setPasswd("");
        modelMap.put("user1",user1);
        return "redirect:/toMain";
    }
    @RequestMapping("/toMain")
    public String toMain()
    {
        return "main";
    }


    @RequestMapping("/toanotherjvm")
    public void toAnotherJvm(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://127.0.0.1:8086/login.jsp");
    }

    @RequestMapping("/callanotherjvmapi")
    public void callanotherjvmapi(HttpServletResponse response) throws IOException {
        String ret = HttpUtil.doGet("https://www.baidu.com/s?ie=utf-8&mod=1&isbd=1&isid=d5b8a6580002170e&ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=ali&oq=ali&rsv_pq=d5b8a6580002170e&rsv_t=063bpnw7FLAeZT1mBQJ9zRaNh3HT6AbDopJPsTJgJlri9HLCJvnoBGOGhvg&rqlang=cn&rsv_enter=0&bs=ali&rsv_sid=26523_1438_26910_21078_18559_26350_20928&_ss=1&clist=3226fd294e96c9b0%093226fd294e96c9b0%09d4781b352dbe3a3f&hsug=&f4s=1&csor=3&_cr1=27919");
        System.out.println(ret);
    }



}
