package com.yousian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String messgae;
    private T data;

    /**
     * 查询为空的时候使用的构造器
     * @param code
     * @param messgae
     */
    public CommonResult(Integer code, String messgae){
        this(code, messgae, null);
    }
}
