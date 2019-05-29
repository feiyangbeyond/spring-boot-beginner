package cn.tsxygfy.restful_crud.config;

import cn.tsxygfy.restful_crud.component.LoginHandlerInterceptor;
import cn.tsxygfy.restful_crud.component.MyLocaleReslover;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
//配置类
@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {

    //国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleReslover();
    }

    //视图映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/login", "/static/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
