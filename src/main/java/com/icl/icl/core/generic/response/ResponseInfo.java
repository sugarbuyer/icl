package com.icl.icl.core.generic.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseInfo {
    private StatusInfo status;
    private Object object;
    private Integer maxIdx;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) private String jsonString;

    public ResponseInfo(StatusInfo status){
        this.status = status;
        this.object = new EmptyResultInfo();
    }

    public ResponseInfo(StatusInfo status, Object object){
        this.status = status;
        this.object = object;
    }

    public ResponseInfo(StatusInfo status, Object object, Integer maxIdx){
        this.status = status;
        this.object = object;
        this.maxIdx = maxIdx;
    }
}
