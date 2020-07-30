package com.caifu.sys.myErrorPage;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
/**
 * @Auther: Lyf
 * @Date: 2020/7/8 14:06
 * @Description:
 */
@Component
public class MyErrorPageRegistrar implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //具体的错误码错误异常页面
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND,"/error/page404");
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/page500");
        //指定具体异常的错误定制页面
        ErrorPage argspage = new ErrorPage(IllegalArgumentException.class,"/error/argsException");
        registry.addErrorPages(e404,e500,argspage);
    }
}
