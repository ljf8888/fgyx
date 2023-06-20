package com.ljf.exception;

import com.ljf.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @description:
 * @author 李炯飞
 * @date: 2023/6/20 20:47
 * @param: 
 * @return: 
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) //异常处理器
    @ResponseBody  //返回json数据
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(null);
    }

    /*
     * @Classname GlobalExceptionHandler
     * @Description TODO
     * @Version 1.0.0
     * @Date 2023/6/20 20:58
     * @Created by 李炯飞
     **/
    @ExceptionHandler(FgyxException.class)
    @ResponseBody
    public Result error(FgyxException exception) {
        return Result.build(null,exception.getCode(),exception.getMessage());
    }
}
