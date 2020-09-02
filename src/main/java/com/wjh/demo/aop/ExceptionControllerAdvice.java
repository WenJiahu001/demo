package com.wjh.demo.aop;

import com.wjh.demo.enums.ResultCodeEnum;
import com.wjh.demo.exception.ServiceException;
import com.wjh.demo.vo.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 监听全局错误异常 统一提示错误信息
 * author wjh
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 参数校检错误的异常监听
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResultVO("参数校检失败:" + objectError.getDefaultMessage(), ResultCodeEnum.VALIDATE_FAILED);
    }

    /**
     * 请求方法不支持的异常提示
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultVO MethodArgumentNotValidExceptionHandler(HttpRequestMethodNotSupportedException e) {
        // 然后提取错误提示信息进行返回
        return new ResultVO(e.getMessage(), ResultCodeEnum.METHOD_FAILED);
    }


    @ExceptionHandler(ServiceException.class)//抛砖引玉，如果报了自定义异常
    public String APIExceptionHandler(ServiceException e) {
        return e.getMsg();
    }
}