package cn.tsxygfy.restful_crud.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleReslover implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //String header = request.getHeader("Accept-Language");

        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();

        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }

        //System.out.println(locale.toString());
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
