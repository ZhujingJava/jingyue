package com.zj.jingyuecommon.util;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
    private String code;
    private String msg;
    private Long count;
    private T data;

    public JsonResult() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static JsonResult success() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(ResultCode.OK.getCode());
        jsonResult.setMsg(ResultCode.OK.getMsg());
        return jsonResult;
    }

    public static JsonResult success(Object data) {
        JsonResult jsonResult = JsonResult.success();
        jsonResult.setData(data);
        return jsonResult;
    }
    public static JsonResult fail() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(ResultCode.FAIL.getCode());
        jsonResult.setMsg(ResultCode.FAIL.getMsg());
        return jsonResult;
    }

    public static JsonResult fail(Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(ResultCode.FAIL.getCode());
        jsonResult.setMsg(ResultCode.FAIL.getMsg());
        jsonResult.setData(data);
        return jsonResult;
    }

}
