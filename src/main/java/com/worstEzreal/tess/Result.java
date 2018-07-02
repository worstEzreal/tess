package com.worstEzreal.tess;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Desc
 *
 * @date 2018/7/2
 */
@Getter
@Setter
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public Result() {

    }
}
