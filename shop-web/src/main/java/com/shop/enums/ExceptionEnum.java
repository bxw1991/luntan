package com.shop.enums;

import lombok.Getter;

@Getter
public enum  ExceptionEnum {

    MG00010(00010,"上传图片错误"),
    MG00011(00011,"发布信息不存在")



    ;
    private Integer code;
    private String message;



    ExceptionEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
