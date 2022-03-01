package com.icl.icl.web.user;

import com.icl.icl.core.generic.entity.EntityInfoImpl;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo extends EntityInfoImpl {
    private Integer userId;
    private String userName;
}
