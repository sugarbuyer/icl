package com.icl.icl.core.generic.response;

public enum StatusEnum {
    SUCCESS(0, "SUCCESS"),

    NOT_FOUND_DATA(-1001, "Not found data"),
    PERMISSION_DENIED(-1002, "Permission denied"),
    NEED_PASSWORD(-1003, "Need password"),
    NEED_USER_AUTH(-1004, "Need user auth"),
    NEED_PARAM(-1004, "Need title or comment"),


    //알 수 없는 Exception
    UNKNOWN_EXCEPTION(-9999,"Unknown exception"); // ???????????????


    private int code;
    private String msg;

    StatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() { return code; }
    public String getMsg() { return msg; }
}
