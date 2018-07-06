package cn.wang.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class MyFilter extends HttpServletRequestWrapper {

    public MyFilter(HttpServletRequest request) {
        super(request);
    }
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if("GET".equalsIgnoreCase(super.getMethod())) {
            try {
                value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
