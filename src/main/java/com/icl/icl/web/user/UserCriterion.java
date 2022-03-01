package com.icl.icl.web.user;

import com.icl.icl.core.generic.criterion.EntityCriterionImpl;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserCriterion extends EntityCriterionImpl {
    private String userName;
}
