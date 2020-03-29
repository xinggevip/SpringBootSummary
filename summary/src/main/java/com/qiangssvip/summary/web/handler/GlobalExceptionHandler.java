package com.qiangssvip.summary.web.handler;

import com.qiangssvip.summary.enunm.ResultCodeEnum;
import com.qiangssvip.summary.exception.UserLoginException;
import com.qiangssvip.summary.utils.HttpResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 通用异常
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)  // 要处理的异常类型
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 自定义异常状态码
    public HttpResult handle(RuntimeException e){
        return HttpResult.failure(ResultCodeEnum.SERVER_ERROR);
    }

    /**
     * 自定义异常
     * @return
     */
    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public HttpResult userLoginExceptionHandle(){
        return HttpResult.failure(ResultCodeEnum.NEED_LOGIN);
    }

    /**
     * 参数错误
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public HttpResult HttpRequestMethodNotSupportedExceptionHandle(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return HttpResult.failure(ResultCodeEnum.PARAM_ERROR,bindingResult);
    }

    /**
     * 消息不可读 前端发送的日期格式不是指定格式
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public HttpResult HttpMessageNotReadableException(HttpMessageNotReadableException e){
        String message = e.getMessage().toString();
        return HttpResult.failure(ResultCodeEnum.PARAM_ERROR, message);
    }


}
