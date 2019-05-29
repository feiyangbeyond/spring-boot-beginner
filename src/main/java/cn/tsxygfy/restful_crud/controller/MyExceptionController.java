package cn.tsxygfy.restful_crud.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionController {

    /**
     * 全局异常处理器
     * @param e 异常
     * @return map
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, Object> errorHandler(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("", e.getMessage());
        return  map;
    }

}
