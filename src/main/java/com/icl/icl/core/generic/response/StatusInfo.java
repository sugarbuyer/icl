package com.icl.icl.core.generic.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusInfo {
    private Integer code;
    private String msg;
    private String param;

    public StatusInfo(StatusEnum statusEnum){
        this.code = statusEnum.getCode();
        this.msg = statusEnum.getMsg();
    }
}
