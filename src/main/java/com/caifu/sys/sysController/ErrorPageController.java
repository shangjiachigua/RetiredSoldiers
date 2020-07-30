package com.caifu.sys.sysController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Lyf
 * @Date: 2020/7/3 19:42
 * @Description:
 */
@Controller
@RequestMapping("/error")
public class ErrorPageController {

    @RequestMapping("/unsafe")
    public String unsafe(){
        return "view/sys/unsafe";
    }

    @RequestMapping("/page404")
    public String page404(){
        return "view/sys/404";
    }

    @RequestMapping("/page500")
    public String page500(){
        return "view/sys/500";
    }

    @RequestMapping("/argsException")
    public String argsException(){
        return "view/sys/argsException";
    }
}
