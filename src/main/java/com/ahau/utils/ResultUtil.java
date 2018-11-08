package com.ahau.utils;

import com.ahau.entity.bamboo.base.Result;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;

    }


    public static Result error() {
        Result result = new Result();
        result.setCode(404);
        result.setMsg("失败");
        return result;

    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
