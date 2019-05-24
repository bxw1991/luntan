package com.shop.handler;


import com.shop.common.base.enums.ErrorCodeEnum;
import com.shop.common.base.exception.BusinessException;
import com.shop.common.utils.WrapMapper;
import com.shop.common.utils.Wrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class  GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper illegalArgumentException(IllegalArgumentException e){
        return WrapMapper.wrap(ErrorCodeEnum.GL99990100.code(),e.getMessage());
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper bizException(BusinessException e){
        return WrapMapper.wrap(e.getCode() == 0 ? Wrapper.ERROR_CODE : e.getCode(), e.getMessage());
    }

}
