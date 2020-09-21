package com.zj.jingyuecommon.util;

public enum ResultCode {
    OK("200","操作成功"),FAIL("-1","操作失败");
    private String code;
    private String msg;
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    ResultCode(String code,String msg){
         this.code=code;
         this.msg=msg;
    }
}
