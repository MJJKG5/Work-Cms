package com.gp.cms.common.exception.advice;

import com.gp.cms.common.exception.LogicException;
import com.gp.cms.common.exception.NullParamException;
import com.gp.cms.model.entity.ResApi;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public ResApi<String> exceptionAdvice(RuntimeException e) {
        // 打印异常
        e.printStackTrace();
        if (e instanceof NullParamException) {
            return new ResApi<>("1001", e.getMessage());
        }
        if (e instanceof LogicException) {
            return new ResApi<>("2001", e.getMessage());
        }
        return new ResApi<>("9999", "未知错误");
    }
}
