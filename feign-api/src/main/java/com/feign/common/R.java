package com.feign.common;

import lombok.Data;

@Data
public class R<T> {

    private T data;
    private Integer code;
    private String msg;

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setData(data);
        r.setCode(200);
        r.setMsg("操作成功!");
        return r;
    }
}
