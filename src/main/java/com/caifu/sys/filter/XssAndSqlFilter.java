package com.caifu.sys.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: Lyf
 * @Date: 2020/7/2 13:02
 * @Description:
 */
public class XssAndSqlFilter implements Filter  {
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String method = "GET";
        String param = "";
        XssAndSqlHttpServletRequestWrapper xssRequest = null;
        if (request instanceof HttpServletRequest) {
            method = ((HttpServletRequest) request).getMethod();
            xssRequest = new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request);
        }
        if ("POST".equalsIgnoreCase(method)) {
            param = this.getBodyString(xssRequest.getReader());
            if(StringUtils.isNotBlank(param)){
                if(xssRequest.checkXSSAndSql(param)){
                    /*response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    //out.write(JSONResponseUtil.getWrappedERRString("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!"));
                    out.write("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!");
                    return ;*/

                    HttpServletResponse resp = (HttpServletResponse)response;
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("application/json;charset=UTF-8");
                    resp.sendRedirect("../error/unsafe");
                    //throw new IllegalArgumentException("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!");
                }
            }
        }
        if (xssRequest.checkParameter()) {
            /*response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            //out.write(JSONResponseUtil.getWrappedERRString("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!"));
            out.write("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!");
            return;*/

            HttpServletResponse resp = (HttpServletResponse)response;
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json;charset=UTF-8");
            resp.sendRedirect("../error/unsafe");
            //throw new IllegalArgumentException("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!");
        }
        chain.doFilter(xssRequest, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

    // 获取request请求body中参数
    public static String getBodyString(BufferedReader br) {
        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return str;
    }
}
