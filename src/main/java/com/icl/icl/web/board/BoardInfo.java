package com.icl.icl.web.board;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.icl.icl.core.generic.entity.EntityInfoImpl;
import com.icl.icl.web.user.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BoardInfo extends EntityInfoImpl {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) private Integer userId;
    private Integer boardId;
    private String title;
    private String comment;
    private UserInfo user;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) private Integer isDelete;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) private String password;
}
