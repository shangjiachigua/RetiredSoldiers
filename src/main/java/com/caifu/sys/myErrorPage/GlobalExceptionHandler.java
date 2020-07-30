package com.caifu.sys.myErrorPage;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @Auther: Lyf
 * @Date: 2020/7/8 14:42
 * @Description:
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String ArithmeticHandler(Exception e){
        return "错误： " + e.getClass().getName();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception e){
        return "错误：" + e.getClass().getName();
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public String UnauthorizedException(Exception e){
        return "错误：该用户无权限！";
    }
}
